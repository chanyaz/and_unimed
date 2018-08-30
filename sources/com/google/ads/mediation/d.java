package com.google.ads.mediation;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzjd;

@VisibleForTesting
final class d extends a implements AppEventListener, zzjd {
    @VisibleForTesting
    private final AbstractAdViewAdapter a;
    @VisibleForTesting
    private final MediationBannerListener b;

    public d(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.a = abstractAdViewAdapter;
        this.b = mediationBannerListener;
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

    public final void onAppEvent(String str, String str2) {
        this.b.zza(this.a, str, str2);
    }
}
