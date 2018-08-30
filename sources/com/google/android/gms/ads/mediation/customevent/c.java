package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.e;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@VisibleForTesting
final class c implements CustomEventNativeListener {
    private final CustomEventAdapter a;
    private final MediationNativeListener b;

    public c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
        this.a = customEventAdapter;
        this.b = mediationNativeListener;
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
        kk.b("Custom event adapter called onAdFailedToLoad.");
        this.b.onAdFailedToLoad(this.a, i);
    }

    public final void onAdImpression() {
        kk.b("Custom event adapter called onAdImpression.");
        this.b.onAdImpression(this.a);
    }

    public final void onAdLeftApplication() {
        kk.b("Custom event adapter called onAdLeftApplication.");
        this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded(b bVar) {
        kk.b("Custom event adapter called onAdLoaded.");
        this.b.onAdLoaded(this.a, bVar);
    }

    public final void onAdLoaded(e eVar) {
        kk.b("Custom event adapter called onAdLoaded.");
        this.b.onAdLoaded(this.a, eVar);
    }

    public final void onAdOpened() {
        kk.b("Custom event adapter called onAdOpened.");
        this.b.onAdOpened(this.a);
    }
}
