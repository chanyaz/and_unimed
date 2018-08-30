package com.google.android.gms.internal.ads;

final class et implements Runnable {
    private final /* synthetic */ gs a;
    private final /* synthetic */ er b;

    et(er erVar, gs gsVar) {
        this.b = erVar;
        this.a = gsVar;
    }

    public final void run() {
        this.b.zzb(new gr(this.a, null, null, null, null, null, null, null));
    }
}
