package com.google.android.gms.internal.ads;

public final class ss extends yd<ss, st> implements zzbcw {
    private static volatile zzbdf<ss> zzakh;
    private static final ss zzdjo = new ss();
    private tb zzdjl;
    private sm zzdjm;
    private int zzdjn;

    static {
        yd.a(ss.class, zzdjo);
    }

    private ss() {
    }

    public static ss d() {
        return zzdjo;
    }

    public final tb a() {
        return this.zzdjl == null ? tb.d() : this.zzdjl;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (su.a[i - 1]) {
            case 1:
                return new ss();
            case 2:
                return new st();
            case 3:
                Object[] objArr = new Object[]{"zzdjl", "zzdjm", "zzdjn"};
                return yd.a(zzdjo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", objArr);
            case 4:
                return zzdjo;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (ss.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdjo);
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

    public final sm b() {
        return this.zzdjm == null ? sm.b() : this.zzdjm;
    }

    public final zzawk c() {
        zzawk a = zzawk.a(this.zzdjn);
        return a == null ? zzawk.UNRECOGNIZED : a;
    }
}
