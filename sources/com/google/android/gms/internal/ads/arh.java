package com.google.android.gms.internal.ads;

final class arh extends fb {
    private final /* synthetic */ aqs a;

    arh(aqs aqs) {
        this.a = aqs;
    }

    public final void onRewardedVideoAdClosed() {
        this.a.a.add(new arl(this));
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.a.a.add(new aro(this, i));
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.a.a.add(new arn(this));
    }

    public final void onRewardedVideoAdLoaded() {
        this.a.a.add(new ari(this));
    }

    public final void onRewardedVideoAdOpened() {
        this.a.a.add(new arj(this));
    }

    public final void onRewardedVideoCompleted() {
        this.a.a.add(new arp(this));
    }

    public final void onRewardedVideoStarted() {
        this.a.a.add(new ark(this));
    }

    public final void zza(zzagu zzagu) {
        this.a.a.add(new arm(this, zzagu));
    }
}
