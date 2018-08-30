package com.google.android.gms.internal.ads;

final class ap implements Runnable {
    private final /* synthetic */ lk a;
    private final /* synthetic */ String b;
    private final /* synthetic */ am c;

    ap(am amVar, lk lkVar, String str) {
        this.c = amVar;
        this.a = lkVar;
        this.b = str;
    }

    public final void run() {
        this.a.b((zzrf) this.c.d.p().get(this.b));
    }
}
