package com.google.android.gms.internal.ads;

public final class sm extends yd<sm, sn> implements zzbcw {
    private static volatile zzbdf<sm> zzakh;
    private static final sm zzdji = new sm();
    private tu zzdjh;

    static {
        yd.a(sm.class, zzdji);
    }

    private sm() {
    }

    public static sm b() {
        return zzdji;
    }

    public final tu a() {
        return this.zzdjh == null ? tu.c() : this.zzdjh;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (so.a[i - 1]) {
            case 1:
                return new sm();
            case 2:
                return new sn();
            case 3:
                Object[] objArr = new Object[]{"zzdjh"};
                return yd.a(zzdji, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0003\u0000\u0000\u0000\u0002\t", objArr);
            case 4:
                return zzdji;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (sm.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdji);
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
}
