package com.google.android.gms.internal.ads;

final class arq implements Runnable {
    private final /* synthetic */ zzts a;
    private final /* synthetic */ arr b;

    arq(aqs aqs, zzts zzts, arr arr) {
        this.a = zzts;
        this.b = arr;
    }

    public final void run() {
        try {
            this.a.zzb(this.b);
        } catch (Throwable e) {
            kk.c("Could not propagate interstitial ad event.", e);
        }
    }
}
