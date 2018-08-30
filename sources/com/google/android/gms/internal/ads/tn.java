package com.google.android.gms.internal.ads;

public final class tn extends yd<tn, to> implements zzbcw {
    private static volatile zzbdf<tn> zzakh;
    private static final tn zzdkr = new tn();
    private int zzdkp;
    private int zzdkq;

    static {
        yd.a(tn.class, zzdkr);
    }

    private tn() {
    }

    public static tn c() {
        return zzdkr;
    }

    public final zzaxa a() {
        zzaxa a = zzaxa.a(this.zzdkp);
        return a == null ? zzaxa.UNRECOGNIZED : a;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (tp.a[i - 1]) {
            case 1:
                return new tn();
            case 2:
                return new to();
            case 3:
                Object[] objArr = new Object[]{"zzdkp", "zzdkq"};
                return yd.a(zzdkr, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0002\u000b", objArr);
            case 4:
                return zzdkr;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (tn.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdkr);
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
        return this.zzdkq;
    }
}
