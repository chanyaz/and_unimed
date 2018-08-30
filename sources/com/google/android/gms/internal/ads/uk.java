package com.google.android.gms.internal.ads;

public final class uk extends yd<uk, ul> implements zzbcw {
    private static volatile zzbdf<uk> zzakh;
    private static final uk zzdmc = new uk();
    private int zzdih;
    private un zzdmb;

    static {
        yd.a(uk.class, zzdmc);
    }

    private uk() {
    }

    public static uk a(zzbah zzbah) {
        return (uk) yd.a(zzdmc, zzbah);
    }

    private final void a(un unVar) {
        if (unVar == null) {
            throw new NullPointerException();
        }
        this.zzdmb = unVar;
    }

    private final void b(int i) {
        this.zzdih = i;
    }

    public static ul c() {
        return (ul) ((ye) zzdmc.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (um.a[i - 1]) {
            case 1:
                return new uk();
            case 2:
                return new ul();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdmb"};
                return yd.a(zzdmc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t", objArr);
            case 4:
                return zzdmc;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uk.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdmc);
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

    public final un b() {
        return this.zzdmb == null ? un.b() : this.zzdmb;
    }
}
