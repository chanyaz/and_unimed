package com.google.android.gms.internal.ads;

final class alr extends akj {
    final /* synthetic */ alp a;

    private alr(alp alp) {
        this.a = alp;
    }

    public final String getMediationAdapterClassName() {
        return null;
    }

    public final boolean isLoading() {
        return false;
    }

    public final void zza(zzjj zzjj, int i) {
        kk.c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        kb.a.post(new als(this));
    }

    public final String zzck() {
        return null;
    }

    public final void zzd(zzjj zzjj) {
        zza(zzjj, 1);
    }
}
