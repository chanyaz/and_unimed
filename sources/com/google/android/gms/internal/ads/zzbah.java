package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class zzbah implements Serializable, Iterable<Byte> {
    public static final zzbah a = new xe(yk.b);
    private static final zzbal b = (wu.a() ? new xf() : new xa());
    private int c = 0;

    zzbah() {
    }

    public static zzbah a(String str) {
        return new xe(str.getBytes(yk.a));
    }

    public static zzbah a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static zzbah a(byte[] bArr, int i, int i2) {
        return new xe(b.zzd(bArr, i, i2));
    }

    static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((((i | i2) | i4) | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    static xc b(int i) {
        return new xc(i, null);
    }

    static zzbah b(byte[] bArr) {
        return new xe(bArr);
    }

    public abstract byte a(int i);

    public abstract int a();

    protected abstract int a(int i, int i2, int i3);

    public abstract zzbah a(int i, int i2);

    protected abstract String a(Charset charset);

    abstract void a(wy wyVar);

    protected abstract void a(byte[] bArr, int i, int i2, int i3);

    public final byte[] b() {
        int a = a();
        if (a == 0) {
            return yk.b;
        }
        byte[] bArr = new byte[a];
        a(bArr, 0, 0, a);
        return bArr;
    }

    public final String c() {
        return a() == 0 ? "" : a(yk.a);
    }

    public abstract boolean d();

    public abstract xg e();

    public abstract boolean equals(Object obj);

    protected final int f() {
        return this.c;
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            i = a();
            i = a(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new wz(this);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a())});
    }
}
