package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@VisibleForTesting
final class a implements CustomEventBannerListener {
    private final CustomEventAdapter a;
    private final MediationBannerListener b;

    public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.a = customEventAdapter;
        this.b = mediationBannerListener;
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

    public final void onAdLeftApplication() {
        kk.b("Custom event adapter called onAdLeftApplication.");
        this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded(View view) {
        kk.b("Custom event adapter called onAdLoaded.");
        this.a.a(view);
        this.b.onAdLoaded(this.a);
    }

    public final void onAdOpened() {
        kk.b("Custom event adapter called onAdOpened.");
        this.b.onAdOpened(this.a);
    }
}
