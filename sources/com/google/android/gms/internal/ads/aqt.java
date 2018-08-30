package com.google.android.gms.internal.ads;

final class aqt extends akh {
    private final /* synthetic */ aqs a;

    aqt(aqs aqs) {
        this.a = aqs;
    }

    public final void onAdClicked() {
        this.a.a.add(new ara(this));
    }

    public final void onAdClosed() {
        this.a.a.add(new aqu(this));
    }

    public final void onAdFailedToLoad(int i) {
        this.a.a.add(new aqv(this, i));
        hl.a("Pooled interstitial failed to load.");
    }

    public final void onAdImpression() {
        this.a.a.add(new aqz(this));
    }

    public final void onAdLeftApplication() {
        this.a.a.add(new aqw(this));
    }

    public final void onAdLoaded() {
        this.a.a.add(new aqx(this));
        hl.a("Pooled interstitial loaded.");
    }

    public final void onAdOpened() {
        this.a.a.add(new aqy(this));
    }
}
