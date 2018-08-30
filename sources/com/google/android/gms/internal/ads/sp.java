package com.google.android.gms.internal.ads;

public final class sp extends yd<sp, sq> implements zzbcw {
    private static volatile zzbdf<sp> zzakh;
    private static final sp zzdjk = new sp();
    private ss zzdjj;

    static {
        yd.a(sp.class, zzdjk);
    }

    private sp() {
    }

    public static sp a(zzbah zzbah) {
        return (sp) yd.a(zzdjk, zzbah);
    }

    public final ss a() {
        return this.zzdjj == null ? ss.d() : this.zzdjj;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (sr.a[i - 1]) {
            case 1:
                return new sp();
            case 2:
                return new sq();
            case 3:
                Object[] objArr = new Object[]{"zzdjj"};
                return yd.a(zzdjk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\t", objArr);
            case 4:
                return zzdjk;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (sp.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdjk);
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
