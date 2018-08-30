package com.google.android.gms.internal.ads;

public final class un extends yd<un, uo> implements zzbcw {
    private static volatile zzbdf<un> zzakh;
    private static final un zzdme = new un();
    private String zzdmd = "";

    static {
        yd.a(un.class, zzdme);
    }

    private un() {
    }

    public static un a(zzbah zzbah) {
        return (un) yd.a(zzdme, zzbah);
    }

    public static un b() {
        return zzdme;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (up.a[i - 1]) {
            case 1:
                return new un();
            case 2:
                return new uo();
            case 3:
                Object[] objArr = new Object[]{"zzdmd"};
                return yd.a(zzdme, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001Ȉ", objArr);
            case 4:
                return zzdme;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (un.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdme);
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

    public final String a() {
        return this.zzdmd;
    }
}
