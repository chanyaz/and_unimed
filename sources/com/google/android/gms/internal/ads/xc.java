package com.google.android.gms.internal.ads;

final class xc {
    private final zzbav a;
    private final byte[] b;

    private xc(int i) {
        this.b = new byte[i];
        this.a = zzbav.a(this.b);
    }

    /* synthetic */ xc(int i, wz wzVar) {
        this(i);
    }

    public final zzbah a() {
        this.a.b();
        return new xe(this.b);
    }

    public final zzbav b() {
        return this.a;
    }
}
