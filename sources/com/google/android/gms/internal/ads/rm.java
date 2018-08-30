package com.google.android.gms.internal.ads;

public final class rm extends yd<rm, rn> implements zzbcw {
    private static volatile zzbdf<rm> zzakh;
    private static final rm zzdis = new rm();
    private rp zzdio;
    private int zzdir;

    static {
        yd.a(rm.class, zzdis);
    }

    private rm() {
    }

    public static rm a(zzbah zzbah) {
        return (rm) yd.a(zzdis, zzbah);
    }

    public static rm c() {
        return zzdis;
    }

    public final rp a() {
        return this.zzdio == null ? rp.b() : this.zzdio;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ro.a[i - 1]) {
            case 1:
                return new rm();
            case 2:
                return new rn();
            case 3:
                Object[] objArr = new Object[]{"zzdio", "zzdir"};
                return yd.a(zzdis, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b", objArr);
            case 4:
                return zzdis;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rm.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdis);
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

    public final int b() {
        return this.zzdir;
    }
}
