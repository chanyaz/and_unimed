package com.google.android.gms.internal.ads;

public final class rp extends yd<rp, rq> implements zzbcw {
    private static volatile zzbdf<rp> zzakh;
    private static final rp zzdiu = new rp();
    private int zzdit;

    static {
        yd.a(rp.class, zzdiu);
    }

    private rp() {
    }

    public static rp b() {
        return zzdiu;
    }

    public final int a() {
        return this.zzdit;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (rr.a[i - 1]) {
            case 1:
                return new rp();
            case 2:
                return new rq();
            case 3:
                Object[] objArr = new Object[]{"zzdit"};
                return yd.a(zzdiu, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\u000b", objArr);
            case 4:
                return zzdiu;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rp.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdiu);
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
