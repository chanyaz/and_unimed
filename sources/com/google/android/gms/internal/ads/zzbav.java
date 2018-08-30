package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbav extends wy {
    private static final Logger b = Logger.getLogger(zzbav.class.getName());
    private static final boolean c = aal.a();
    xn a = this;

    public final class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzbav() {
    }

    /* synthetic */ zzbav(xm xmVar) {
        this();
    }

    public static int a(int i, yq yqVar) {
        int e = e(i);
        int b = yqVar.b();
        return e + (b + g(b));
    }

    public static int a(yq yqVar) {
        int b = yqVar.b();
        return b + g(b);
    }

    static int a(zzbcu zzbcu, zzbdm zzbdm) {
        wp wpVar = (wp) zzbcu;
        int h = wpVar.h();
        if (h == -1) {
            h = zzbdm.zzy(wpVar);
            wpVar.a(h);
        }
        return h + g(h);
    }

    public static zzbav a(byte[] bArr) {
        return new xl(bArr, 0, bArr.length);
    }

    public static int b(double d) {
        return 8;
    }

    public static int b(float f) {
        return 4;
    }

    public static int b(int i, double d) {
        return e(i) + 8;
    }

    public static int b(int i, float f) {
        return e(i) + 4;
    }

    public static int b(int i, yq yqVar) {
        return ((e(1) << 1) + g(2, i)) + a(3, yqVar);
    }

    public static int b(int i, zzbcu zzbcu) {
        return ((e(1) << 1) + g(2, i)) + (e(3) + b(zzbcu));
    }

    static int b(int i, zzbcu zzbcu, zzbdm zzbdm) {
        return e(i) + a(zzbcu, zzbdm);
    }

    public static int b(int i, String str) {
        return e(i) + b(str);
    }

    public static int b(int i, boolean z) {
        return e(i) + 1;
    }

    public static int b(zzbah zzbah) {
        int a = zzbah.a();
        return a + g(a);
    }

    public static int b(zzbcu zzbcu) {
        int zzacw = zzbcu.zzacw();
        return zzacw + g(zzacw);
    }

    public static int b(String str) {
        int a;
        try {
            a = aar.a((CharSequence) str);
        } catch (aau e) {
            a = str.getBytes(yk.a).length;
        }
        return a + g(a);
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return length + g(length);
    }

    public static int c(int i, zzbah zzbah) {
        int e = e(i);
        int a = zzbah.a();
        return e + (a + g(a));
    }

    @Deprecated
    static int c(int i, zzbcu zzbcu, zzbdm zzbdm) {
        int e = e(i) << 1;
        wp wpVar = (wp) zzbcu;
        int h = wpVar.h();
        if (h == -1) {
            h = zzbdm.zzy(wpVar);
            wpVar.a(h);
        }
        return h + e;
    }

    @Deprecated
    public static int c(zzbcu zzbcu) {
        return zzbcu.zzacw();
    }

    public static int d(int i, long j) {
        return e(i) + e(j);
    }

    public static int d(int i, zzbah zzbah) {
        return ((e(1) << 1) + g(2, i)) + c(3, zzbah);
    }

    public static int d(long j) {
        return e(j);
    }

    public static int e(int i) {
        return g(i << 3);
    }

    public static int e(int i, long j) {
        return e(i) + e(j);
    }

    public static int e(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        long j2;
        int i = 2;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j2 = j >>> 28;
        } else {
            j2 = j;
        }
        if ((-2097152 & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i + 1 : i;
    }

    public static int f(int i) {
        return i >= 0 ? g(i) : 10;
    }

    public static int f(int i, int i2) {
        return e(i) + f(i2);
    }

    public static int f(int i, long j) {
        return e(i) + e(i(j));
    }

    public static int f(long j) {
        return e(i(j));
    }

    public static int g(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int g(int i, int i2) {
        return e(i) + g(i2);
    }

    public static int g(int i, long j) {
        return e(i) + 8;
    }

    public static int g(long j) {
        return 8;
    }

    public static int h(int i) {
        return g(m(i));
    }

    public static int h(int i, int i2) {
        return e(i) + g(m(i2));
    }

    public static int h(int i, long j) {
        return e(i) + 8;
    }

    public static int h(long j) {
        return 8;
    }

    public static int i(int i) {
        return 4;
    }

    public static int i(int i, int i2) {
        return e(i) + 4;
    }

    private static long i(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int j(int i) {
        return 4;
    }

    public static int j(int i, int i2) {
        return e(i) + 4;
    }

    public static int k(int i) {
        return f(i);
    }

    public static int k(int i, int i2) {
        return e(i) + f(i2);
    }

    @Deprecated
    public static int l(int i) {
        return g(i);
    }

    private static int m(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public abstract int a();

    public abstract void a(byte b);

    public final void a(double d) {
        c(Double.doubleToRawLongBits(d));
    }

    public final void a(float f) {
        d(Float.floatToRawIntBits(f));
    }

    public abstract void a(int i);

    public final void a(int i, double d) {
        c(i, Double.doubleToRawLongBits(d));
    }

    public final void a(int i, float f) {
        e(i, Float.floatToRawIntBits(f));
    }

    public abstract void a(int i, int i2);

    public abstract void a(int i, long j);

    public abstract void a(int i, zzbah zzbah);

    public abstract void a(int i, zzbcu zzbcu);

    abstract void a(int i, zzbcu zzbcu, zzbdm zzbdm);

    public abstract void a(int i, String str);

    public abstract void a(int i, boolean z);

    public abstract void a(long j);

    public abstract void a(zzbah zzbah);

    public abstract void a(zzbcu zzbcu);

    public abstract void a(String str);

    final void a(String str, aau aau) {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", aau);
        byte[] bytes = str.getBytes(yk.a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (Throwable e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    public final void a(boolean z) {
        a((byte) (z ? 1 : 0));
    }

    public final void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void b(int i);

    public abstract void b(int i, int i2);

    public final void b(int i, long j) {
        a(i, i(j));
    }

    public abstract void b(int i, zzbah zzbah);

    public final void b(long j) {
        a(i(j));
    }

    public abstract void b(byte[] bArr, int i, int i2);

    public final void c(int i) {
        b(m(i));
    }

    public abstract void c(int i, int i2);

    public abstract void c(int i, long j);

    public abstract void c(long j);

    abstract void c(byte[] bArr, int i, int i2);

    public abstract void d(int i);

    public final void d(int i, int i2) {
        c(i, m(i2));
    }

    public abstract void e(int i, int i2);
}
