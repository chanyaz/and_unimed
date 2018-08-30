package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;

public class VastManager implements VastXmlManagerAggregatorListener {
    @Nullable
    private VastManagerListener a;
    @Nullable
    private VastXmlManagerAggregator b;
    @Nullable
    private String c;
    private double d;
    private int e;
    private final boolean f;

    public interface VastManagerListener {
        void onVastVideoConfigurationPrepared(@Nullable VastVideoConfig vastVideoConfig);
    }

    public VastManager(@NonNull Context context, boolean z) {
        a(context);
        this.f = z;
    }

    private void a(@NonNull Context context) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        float f = context.getResources().getDisplayMetrics().density;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        int max = Math.max(width, height);
        width = Math.min(width, height);
        this.d = ((double) max) / ((double) width);
        this.e = (int) ((((float) width) / f) * (((float) max) / f));
    }

    private boolean a(@NonNull VastVideoConfig vastVideoConfig) {
        Preconditions.checkNotNull(vastVideoConfig, "vastVideoConfig cannot be null");
        String networkMediaFileUrl = vastVideoConfig.getNetworkMediaFileUrl();
        if (!CacheService.containsKeyDiskCache(networkMediaFileUrl)) {
            return false;
        }
        vastVideoConfig.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(networkMediaFileUrl));
        return true;
    }

    public void cancel() {
        if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
        }
    }

    public void onAggregationComplete(@Nullable final VastVideoConfig vastVideoConfig) {
        if (this.a == null) {
            throw new IllegalStateException("mVastManagerListener cannot be null here. Did you call prepareVastVideoConfiguration()?");
        } else if (vastVideoConfig == null) {
            this.a.onVastVideoConfigurationPrepared(null);
        } else {
            if (!TextUtils.isEmpty(this.c)) {
                vastVideoConfig.setDspCreativeId(this.c);
            }
            if (!this.f || a(vastVideoConfig)) {
                this.a.onVastVideoConfigurationPrepared(vastVideoConfig);
                return;
            }
            VideoDownloader.cache(vastVideoConfig.getNetworkMediaFileUrl(), new VideoDownloaderListener() {
                public void onComplete(boolean z) {
                    if (z && VastManager.this.a(vastVideoConfig)) {
                        VastManager.this.a.onVastVideoConfigurationPrepared(vastVideoConfig);
                        return;
                    }
                    MoPubLog.d("Failed to download VAST video.");
                    VastManager.this.a.onVastVideoConfigurationPrepared(null);
                }
            });
        }
    }

    public void prepareVastVideoConfiguration(@Nullable String str, @NonNull VastManagerListener vastManagerListener, @Nullable String str2, @NonNull Context context) {
        Preconditions.checkNotNull(vastManagerListener, "vastManagerListener cannot be null");
        Preconditions.checkNotNull(context, "context cannot be null");
        if (this.b == null) {
            this.a = vastManagerListener;
            this.b = new VastXmlManagerAggregator(this, this.d, this.e, context.getApplicationContext());
            this.c = str2;
            try {
                AsyncTasks.safeExecuteOnExecutor(this.b, str);
            } catch (Throwable e) {
                MoPubLog.d("Failed to aggregate vast xml", e);
                this.a.onVastVideoConfigurationPrepared(null);
            }
        }
    }
}
