package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public abstract class xg {
    private static volatile boolean f;
    int a;
    int b;
    xj c;
    private int d;
    private boolean e;

    static {
        f = false;
        f = true;
    }

    private xg() {
        this.b = 100;
        this.d = MoPubClientPositioning.NO_REPEAT;
        this.e = false;
    }

    /* synthetic */ xg(xh xhVar) {
        this();
    }

    public static long a(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    static xg a(byte[] bArr, int i, int i2, boolean z) {
        xg xiVar = new xi(bArr, i, i2, z, null);
        try {
            xiVar.c(i2);
            return xiVar;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int f(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public abstract int a();

    public abstract void a(int i);

    public abstract double b();

    public abstract boolean b(int i);

    public abstract float c();

    public abstract int c(int i);

    public abstract long d();

    public abstract void d(int i);

    public abstract long e();

    public abstract void e(int i);

    public abstract int f();

    public abstract long g();

    public abstract int h();

    public abstract boolean i();

    public abstract String j();

    public abstract String k();

    public abstract zzbah l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    abstract long s();

    public abstract boolean t();

    public abstract int u();
}
