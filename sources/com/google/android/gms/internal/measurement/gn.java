package com.google.android.gms.internal.measurement;

final class gn implements Runnable {
    private final /* synthetic */ gk a;
    private final /* synthetic */ gl b;

    gn(gl glVar, gk gkVar) {
        this.b = glVar;
        this.a = gkVar;
    }

    public final void run() {
        this.b.a(this.a);
        this.b.a = null;
        this.b.h().a(null);
    }
}
