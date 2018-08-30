package com.google.android.gms.internal.measurement;

final class gf implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ fq b;

    gf(fq fqVar, boolean z) {
        this.b = fqVar;
        this.a = z;
    }

    public final void run() {
        this.b.c(this.a);
    }
}
