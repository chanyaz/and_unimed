package com.google.android.gms.internal.ads;

final class df implements Runnable {
    private final /* synthetic */ gs a;
    private final /* synthetic */ de b;

    df(de deVar, gs gsVar) {
        this.b = deVar;
        this.a = gsVar;
    }

    public final void run() {
        this.b.h.zza(this.a);
        if (this.b.l != null) {
            this.b.l.c();
            this.b.l = null;
        }
    }
}
