package com.google.ads.mediation;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzjd;

@VisibleForTesting
final class e extends a implements zzjd {
    @VisibleForTesting
    private final AbstractAdViewAdapter a;
    @VisibleForTesting
    private final MediationInterstitialListener b;

    public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.a = abstractAdViewAdapter;
        this.b = mediationInterstitialListener;
    }

    public final void onAdClicked() {
        this.b.onAdClicked(this.a);
    }

    public final void onAdClosed() {
        this.b.onAdClosed(this.a);
    }

    public final void onAdFailedToLoad(int i) {
        this.b.onAdFailedToLoad(this.a, i);
    }

    public final void onAdLeftApplication() {
        this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded() {
        this.b.onAdLoaded(this.a);
    }

    public final void onAdOpened() {
        this.b.onAdOpened(this.a);
    }
}
