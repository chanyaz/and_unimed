package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventInterstitialAdapter implements CustomEventInterstitialListener {
    public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;
    private final MoPubInterstitial a;
    private boolean b;
    private CustomEventInterstitialAdapterListener c;
    private CustomEventInterstitial d;
    private Context e;
    private Map<String, Object> f;
    private Map<String, String> g;
    private final Handler h = new Handler();
    private final Runnable i;

    interface CustomEventInterstitialAdapterListener {
        void onCustomEventInterstitialClicked();

        void onCustomEventInterstitialDismissed();

        void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onCustomEventInterstitialLoaded();

        void onCustomEventInterstitialShown();
    }

    public CustomEventInterstitialAdapter(@NonNull MoPubInterstitial moPubInterstitial, @NonNull String str, @NonNull Map<String, String> map, long j, @Nullable AdReport adReport) {
        Preconditions.checkNotNull(map);
        this.a = moPubInterstitial;
        this.e = this.a.getActivity();
        this.i = new Runnable() {
            public void run() {
                MoPubLog.d("Third-party network timed out.");
                CustomEventInterstitialAdapter.this.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
                CustomEventInterstitialAdapter.this.c();
            }
        };
        MoPubLog.d("Attempting to invoke custom event: " + str);
        try {
            this.d = CustomEventInterstitialFactory.create(str);
            this.g = new TreeMap(map);
            this.f = this.a.getLocalExtras();
            if (this.a.getLocation() != null) {
                this.f.put("location", this.a.getLocation());
            }
            this.f.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(j));
            this.f.put(DataKeys.AD_REPORT_KEY, adReport);
        } catch (Exception e) {
            MoPubLog.d("Couldn't locate or instantiate custom event: " + str + ".");
            this.a.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    private void e() {
        this.h.removeCallbacks(this.i);
    }

    private int f() {
        return (this.a == null || this.a.b() == null || this.a.b().intValue() < 0) ? 30000 : this.a.b().intValue() * 1000;
    }

    void a() {
        if (!d() && this.d != null) {
            this.h.postDelayed(this.i, (long) f());
            try {
                this.d.loadInterstitial(this.e, this, this.f, this.g);
            } catch (Throwable e) {
                MoPubLog.d("Loading a custom event interstitial threw an exception.", e);
                onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        }
    }

    void a(CustomEventInterstitialAdapterListener customEventInterstitialAdapterListener) {
        this.c = customEventInterstitialAdapterListener;
    }

    void b() {
        if (!d() && this.d != null) {
            try {
                this.d.showInterstitial();
            } catch (Throwable e) {
                MoPubLog.d("Showing a custom event interstitial threw an exception.", e);
                onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        }
    }

    void c() {
        if (this.d != null) {
            try {
                this.d.onInvalidate();
            } catch (Throwable e) {
                MoPubLog.d("Invalidating a custom event interstitial threw an exception.", e);
            }
        }
        this.d = null;
        this.e = null;
        this.g = null;
        this.f = null;
        this.c = null;
        this.b = true;
    }

    boolean d() {
        return this.b;
    }

    public void onInterstitialClicked() {
        if (!d() && this.c != null) {
            this.c.onCustomEventInterstitialClicked();
        }
    }

    public void onInterstitialDismissed() {
        if (!d() && this.c != null) {
            this.c.onCustomEventInterstitialDismissed();
        }
    }

    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (!d() && this.c != null) {
            if (moPubErrorCode == null) {
                moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
            }
            e();
            this.c.onCustomEventInterstitialFailed(moPubErrorCode);
        }
    }

    public void onInterstitialLoaded() {
        if (!d()) {
            e();
            if (this.c != null) {
                this.c.onCustomEventInterstitialLoaded();
            }
        }
    }

    public void onInterstitialShown() {
        if (!d() && this.c != null) {
            this.c.onCustomEventInterstitialShown();
        }
    }

    public void onLeaveApplication() {
        onInterstitialClicked();
    }
}
