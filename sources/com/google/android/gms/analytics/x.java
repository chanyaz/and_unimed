package com.google.android.gms.analytics;

final class x implements Runnable {
    private final /* synthetic */ q a;
    private final /* synthetic */ t b;

    x(t tVar, q qVar) {
        this.b = tVar;
        this.a = qVar;
    }

    public final void run() {
        this.a.h().a(this.a);
        for (zzn zza : this.b.c) {
            zza.zza(this.a);
        }
        t.b(this.a);
    }
}
