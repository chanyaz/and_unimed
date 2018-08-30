package com.google.android.gms.internal.ads;

public final class sc extends yd<sc, sd> implements zzbcw {
    private static volatile zzbdf<sc> zzakh;
    private static final sc zzdiz = new sc();
    private int zzdih;
    private zzbah zzdip = zzbah.a;

    static {
        yd.a(sc.class, zzdiz);
    }

    private sc() {
    }

    public static sc a(zzbah zzbah) {
        return (sc) yd.a(zzdiz, zzbah);
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

    public static sd c() {
        return (sd) ((ye) zzdiz.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (se.a[i - 1]) {
            case 1:
                return new sc();
            case 2:
                return new sd();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdip"};
                return yd.a(zzdiz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0003\n", objArr);
            case 4:
                return zzdiz;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (sc.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdiz);
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

    public final zzbah b() {
        return this.zzdip;
    }
}
