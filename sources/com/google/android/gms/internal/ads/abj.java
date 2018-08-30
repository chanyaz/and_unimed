package com.google.android.gms.internal.ads;

public abstract class abj {
    protected volatile int Z = -1;

    public static final <T extends abj> T a(T t, byte[] bArr) {
        return a(t, bArr, 0, bArr.length);
    }

    private static final <T extends abj> T a(T t, byte[] bArr, int i, int i2) {
        try {
            abb a = abb.a(bArr, 0, i2);
            t.a(a);
            a.a(0);
            return t;
        } catch (zzbfh e) {
            throw e;
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] a(abj abj) {
        byte[] bArr = new byte[abj.d()];
        try {
            abd a = abd.a(bArr, 0, bArr.length);
            abj.a(a);
            a.a();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    protected int a() {
        return 0;
    }

    public abstract abj a(abb abb);

    public void a(abd abd) {
    }

    /* renamed from: c */
    public abj clone() {
        return (abj) super.clone();
    }

    public final int d() {
        int a = a();
        this.Z = a;
        return a;
    }

    public String toString() {
        return abk.a(this);
    }
}
