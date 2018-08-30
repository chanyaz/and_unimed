package com.google.android.gms.internal.ads;

public final class th extends yd<th, ti> implements zzbcw {
    private static volatile zzbdf<th> zzakh;
    private static final th zzdkn = new th();
    private int zzdih;
    private zzbah zzdip = zzbah.a;
    private tn zzdkm;

    static {
        yd.a(th.class, zzdkn);
    }

    private th() {
    }

    public static th a(zzbah zzbah) {
        return (th) yd.a(zzdkn, zzbah);
    }

    private final void a(tn tnVar) {
        if (tnVar == null) {
            throw new NullPointerException();
        }
        this.zzdkm = tnVar;
    }

    private final void b(int i) {
        this.zzdih = i;
    }

    private final void b(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdip = zzbah;
    }

    public static ti d() {
        return (ti) ((ye) zzdkn.a(yi.e, null, null));
    }

    public static th e() {
        return zzdkn;
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (tj.a[i - 1]) {
            case 1:
                return new th();
            case 2:
                return new ti();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdkm", "zzdip"};
                return yd.a(zzdkn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdkn;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (th.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdkn);
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

    public final tn b() {
        return this.zzdkm == null ? tn.c() : this.zzdkm;
    }

    public final zzbah c() {
        return this.zzdip;
    }
}
