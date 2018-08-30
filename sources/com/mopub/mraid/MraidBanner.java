package com.mopub.mraid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.MraidControllerFactory;
import com.mopub.mraid.MraidController.MraidListener;
import java.util.Map;

class MraidBanner extends CustomEventBanner {
    @Nullable
    private MraidController a;
    @Nullable
    private CustomEventBannerListener b;
    @Nullable
    private MraidWebViewDebugListener c;

    MraidBanner() {
    }

    private boolean a(Map<String, String> map) {
        return map.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    protected void a() {
        if (this.a != null) {
            this.a.setMraidListener(null);
            this.a.destroy();
        }
    }

    protected void a(@NonNull Context context, @NonNull CustomEventBannerListener customEventBannerListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        this.b = customEventBannerListener;
        if (a((Map) map2)) {
            String str = (String) map2.get(DataKeys.HTML_RESPONSE_BODY_KEY);
            try {
                this.a = MraidControllerFactory.create(context, (AdReport) map.get(DataKeys.AD_REPORT_KEY), PlacementType.INLINE);
                this.a.setDebugListener(this.c);
                this.a.setMraidListener(new MraidListener() {
                    public void onClose() {
                        MraidBanner.this.b.onBannerCollapsed();
                    }

                    public void onExpand() {
                        MraidBanner.this.b.onBannerExpanded();
                        MraidBanner.this.b.onBannerClicked();
                    }

                    public void onFailedToLoad() {
                        MraidBanner.this.b.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                    }

                    public void onLoaded(View view) {
                        AdViewController.setShouldHonorServerDimensions(view);
                        MraidBanner.this.b.onBannerLoaded(view);
                    }

                    public void onOpen() {
                        MraidBanner.this.b.onBannerClicked();
                    }
                });
                this.a.loadContent(str);
                return;
            } catch (Throwable e) {
                MoPubLog.w("MRAID banner creating failed:", e);
                this.b.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                return;
            }
        }
        this.b.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }

    @VisibleForTesting
    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.c = mraidWebViewDebugListener;
        if (this.a != null) {
            this.a.setDebugListener(mraidWebViewDebugListener);
        }
    }
}
