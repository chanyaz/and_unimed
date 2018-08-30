package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@VisibleForTesting
final class b implements CustomEventInterstitialListener {
    private final CustomEventAdapter a;
    private final MediationInterstitialListener b;
    private final /* synthetic */ CustomEventAdapter c;

    public b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.c = customEventAdapter;
        this.a = customEventAdapter2;
        this.b = mediationInterstitialListener;
    }

    public final void onAdClicked() {
        kk.b("Custom event adapter called onAdClicked.");
        this.b.onAdClicked(this.a);
    }

    public final void onAdClosed() {
        kk.b("Custom event adapter called onAdClosed.");
        this.b.onAdClosed(this.a);
    }

    public final void onAdFailedToLoad(int i) {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onAdFailedToLoad(this.a, i);
    }

    public final void onAdLeftApplication() {
        kk.b("Custom event adapter called onAdLeftApplication.");
        this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded() {
        kk.b("Custom event adapter called onReceivedAd.");
        this.b.onAdLoaded(this.c);
    }

    public final void onAdOpened() {
        kk.b("Custom event adapter called onAdOpened.");
        this.b.onAdOpened(this.a);
    }
}
