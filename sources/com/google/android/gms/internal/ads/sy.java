package com.google.android.gms.internal.ads;

public final class sy extends yd<sy, sz> implements zzbcw {
    private static volatile zzbdf<sy> zzakh;
    private static final sy zzdjt = new sy();
    private int zzdih;
    private ss zzdjj;
    private zzbah zzdjr = zzbah.a;
    private zzbah zzdjs = zzbah.a;

    static {
        yd.a(sy.class, zzdjt);
    }

    private sy() {
    }

    public static sy a(zzbah zzbah) {
        return (sy) yd.a(zzdjt, zzbah);
    }

    private final void a(ss ssVar) {
        if (ssVar == null) {
            throw new NullPointerException();
        }
        this.zzdjj = ssVar;
    }

    private final void b(int i) {
        this.zzdih = i;
    }

    private final void b(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdjr = zzbah;
    }

    private final void c(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdjs = zzbah;
    }

    public static sz e() {
        return (sz) ((ye) zzdjt.a(yi.e, null, null));
    }

    public static sy f() {
        return zzdjt;
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ta.a[i - 1]) {
            case 1:
                return new sy();
            case 2:
                return new sz();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdjj", "zzdjr", "zzdjs"};
                return yd.a(zzdjt, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", objArr);
            case 4:
                return zzdjt;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (sy.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdjt);
                        zzakh = obj3;
                    }
                }
                return obj3;
            case 6:
                return Byte.valueOf((byte) 1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final ss b() {
        return this.zzdjj == null ? ss.d() : this.zzdjj;
    }

    public final zzbah c() {
        return this.zzdjr;
    }

    public final zzbah d() {
        return this.zzdjs;
    }
}
