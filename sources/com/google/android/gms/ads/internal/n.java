package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzaig;

final class n implements zzahu {
    private final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final void onRewardedVideoAdClosed() {
        this.a.zzcb();
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.a.c();
    }

    public final void onRewardedVideoAdOpened() {
        this.a.zzcc();
    }

    public final void onRewardedVideoCompleted() {
        this.a.zzdl();
    }

    public final void onRewardedVideoStarted() {
        this.a.zzdk();
    }

    public final void zzc(zzaig zzaig) {
        this.a.zzb(zzaig);
    }

    public final void zzdm() {
        this.a.onAdClicked();
    }
}
