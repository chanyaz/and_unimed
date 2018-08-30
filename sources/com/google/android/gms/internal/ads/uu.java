package com.google.android.gms.internal.ads;

public final class uu extends yd<uu, uv> implements zzbcw {
    private static volatile zzbdf<uu> zzakh;
    private static final uu zzdmj = new uu();
    private String zzdmh = "";
    private tu zzdmi;

    static {
        yd.a(uu.class, zzdmj);
    }

    private uu() {
    }

    public static uu a(zzbah zzbah) {
        return (uu) yd.a(zzdmj, zzbah);
    }

    public static uu c() {
        return zzdmj;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (uw.a[i - 1]) {
            case 1:
                return new uu();
            case 2:
                return new uv();
            case 3:
                Object[] objArr = new Object[]{"zzdmh", "zzdmi"};
                return yd.a(zzdmj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\t", objArr);
            case 4:
                return zzdmj;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uu.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdmj);
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
        return this.zzdmh;
    }

    public final tu b() {
        return this.zzdmi == null ? tu.c() : this.zzdmi;
    }
}
