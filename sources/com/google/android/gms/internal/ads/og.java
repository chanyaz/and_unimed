package com.google.android.gms.internal.ads;

final /* synthetic */ class og implements Runnable {
    private final oe a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;

    og(oe oeVar, int i, int i2, boolean z, boolean z2) {
        this.a = oeVar;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final void run() {
        this.a.a(this.b, this.c, this.d, this.e);
    }
}
