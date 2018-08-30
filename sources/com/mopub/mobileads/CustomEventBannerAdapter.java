package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventBannerAdapter implements CustomEventBannerListener {
    public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;
    private boolean a;
    private MoPubView b;
    private Context c;
    private CustomEventBanner d;
    private Map<String, Object> e;
    private Map<String, String> f;
    private final Handler g = new Handler();
    private final Runnable h;
    private boolean i;

    public CustomEventBannerAdapter(@NonNull MoPubView moPubView, @NonNull String str, @NonNull Map<String, String> map, long j, @Nullable AdReport adReport) {
        Preconditions.checkNotNull(map);
        this.b = moPubView;
        this.c = moPubView.getContext();
        this.h = new Runnable() {
            public void run() {
                MoPubLog.d("Third-party network timed out.");
                CustomEventBannerAdapter.this.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
                CustomEventBannerAdapter.this.b();
            }
        };
        MoPubLog.d("Attempting to invoke custom event: " + str);
        try {
            this.d = CustomEventBannerFactory.create(str);
            this.f = new TreeMap(map);
            this.e = this.b.getLocalExtras();
            if (this.b.getLocation() != null) {
                this.e.put("location", this.b.getLocation());
            }
            this.e.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(j));
            this.e.put(DataKeys.AD_REPORT_KEY, adReport);
            this.e.put(DataKeys.AD_WIDTH, Integer.valueOf(this.b.getAdWidth()));
            this.e.put(DataKeys.AD_HEIGHT, Integer.valueOf(this.b.getAdHeight()));
        } catch (Exception e) {
            MoPubLog.d("Couldn't locate or instantiate custom event: " + str + ".");
            this.b.b(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    private void d() {
        this.g.removeCallbacks(this.h);
    }

    private int e() {
        return (this.b == null || this.b.getAdTimeoutDelay() == null || this.b.getAdTimeoutDelay().intValue() < 0) ? 10000 : this.b.getAdTimeoutDelay().intValue() * 1000;
    }

    void a() {
        if (!c() && this.d != null) {
            this.g.postDelayed(this.h, (long) e());
            try {
                this.d.a(this.c, this, this.e, this.f);
            } catch (Throwable e) {
                MoPubLog.d("Loading a custom event banner threw an exception.", e);
                onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        }
    }

    void b() {
        if (this.d != null) {
            try {
                this.d.a();
            } catch (Throwable e) {
                MoPubLog.d("Invalidating a custom event banner threw an exception", e);
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = true;
    }

    boolean c() {
        return this.a;
    }

    public void onBannerClicked() {
        if (!c() && this.b != null) {
            this.b.b();
        }
    }

    public void onBannerCollapsed() {
        if (!c()) {
            this.b.setAutorefreshEnabled(this.i);
            this.b.f();
        }
    }

    public void onBannerExpanded() {
        if (!c()) {
            this.i = this.b.getAutorefreshEnabled();
            this.b.setAutorefreshEnabled(false);
            this.b.e();
        }
    }

    public void onBannerFailed(MoPubErrorCode moPubErrorCode) {
        if (!c() && this.b != null) {
            if (moPubErrorCode == null) {
                moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
            }
            d();
            this.b.b(moPubErrorCode);
        }
    }

    public void onBannerLoaded(View view) {
        if (!c()) {
            d();
            if (this.b != null) {
                this.b.h();
                this.b.setAdContentView(view);
                if (!(view instanceof HtmlBannerWebView)) {
                    this.b.c();
                }
            }
        }
    }

    public void onLeaveApplication() {
        onBannerClicked();
    }
}
