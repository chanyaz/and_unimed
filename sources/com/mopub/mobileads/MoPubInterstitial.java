package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;

public class MoPubInterstitial implements CustomEventInterstitialAdapterListener {
    private MoPubInterstitialView a = new MoPubInterstitialView(this.d);
    private CustomEventInterstitialAdapter b;
    private InterstitialAdListener c;
    private Activity d;
    private String e;
    private m f;
    private boolean g;

    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    public class MoPubInterstitialView extends MoPubView {
        public MoPubInterstitialView(Context context) {
            super(context);
            setAutorefreshEnabled(false);
        }

        protected void a() {
            MoPubLog.d("Tracking impression for interstitial.");
            if (this.b != null) {
                this.b.f();
            }
        }

        protected void a(MoPubErrorCode moPubErrorCode) {
            if (MoPubInterstitial.this.c != null) {
                MoPubInterstitial.this.c.onInterstitialFailed(MoPubInterstitial.this, moPubErrorCode);
            }
        }

        protected void a(String str, Map<String, String> map) {
            if (this.b != null) {
                if (TextUtils.isEmpty(str)) {
                    MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
                    b(MoPubErrorCode.ADAPTER_NOT_FOUND);
                    return;
                }
                if (MoPubInterstitial.this.b != null) {
                    MoPubInterstitial.this.b.c();
                }
                MoPubLog.d("Loading custom event interstitial adapter.");
                MoPubInterstitial.this.b = CustomEventInterstitialAdapterFactory.create(MoPubInterstitial.this, str, map, this.b.getBroadcastIdentifier(), this.b.getAdReport());
                MoPubInterstitial.this.b.a(MoPubInterstitial.this);
                MoPubInterstitial.this.b.a();
            }
        }

        public AdFormat getAdFormat() {
            return AdFormat.INTERSTITIAL;
        }
    }

    public MoPubInterstitial(Activity activity, String str) {
        this.d = activity;
        this.e = str;
        this.a.setAdUnitId(this.e);
        this.f = m.NOT_READY;
    }

    private void c() {
        this.f = m.NOT_READY;
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
        this.g = false;
    }

    private void d() {
        if (this.b != null) {
            this.b.b();
        }
    }

    boolean a() {
        return this.g;
    }

    Integer b() {
        return this.a.getAdTimeoutDelay();
    }

    public void destroy() {
        this.g = true;
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
        this.a.setBannerAdListener(null);
        this.a.destroy();
    }

    public void forceRefresh() {
        c();
        this.a.forceRefresh();
    }

    public Activity getActivity() {
        return this.d;
    }

    public InterstitialAdListener getInterstitialAdListener() {
        return this.c;
    }

    public String getKeywords() {
        return this.a.getKeywords();
    }

    public Map<String, Object> getLocalExtras() {
        return this.a.getLocalExtras();
    }

    public Location getLocation() {
        return this.a.getLocation();
    }

    public boolean getTesting() {
        return this.a.getTesting();
    }

    public boolean isReady() {
        return this.f.a();
    }

    public void load() {
        c();
        this.a.loadAd();
    }

    public void onCustomEventInterstitialClicked() {
        if (!a()) {
            this.a.b();
            if (this.c != null) {
                this.c.onInterstitialClicked(this);
            }
        }
    }

    public void onCustomEventInterstitialDismissed() {
        if (!a()) {
            this.f = m.NOT_READY;
            if (this.c != null) {
                this.c.onInterstitialDismissed(this);
            }
        }
    }

    public void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (!a()) {
            this.f = m.NOT_READY;
            this.a.b(moPubErrorCode);
        }
    }

    public void onCustomEventInterstitialLoaded() {
        if (!this.g) {
            this.f = m.CUSTOM_EVENT_AD_READY;
            if (this.c != null) {
                this.c.onInterstitialLoaded(this);
            }
        }
    }

    public void onCustomEventInterstitialShown() {
        if (!a()) {
            this.a.a();
            if (this.c != null) {
                this.c.onInterstitialShown(this);
            }
        }
    }

    public void setInterstitialAdListener(InterstitialAdListener interstitialAdListener) {
        this.c = interstitialAdListener;
    }

    public void setKeywords(String str) {
        this.a.setKeywords(str);
    }

    public void setLocalExtras(Map<String, Object> map) {
        this.a.setLocalExtras(map);
    }

    public void setTesting(boolean z) {
        this.a.setTesting(z);
    }

    public boolean show() {
        switch (this.f) {
            case CUSTOM_EVENT_AD_READY:
                d();
                return true;
            default:
                return false;
        }
    }
}
