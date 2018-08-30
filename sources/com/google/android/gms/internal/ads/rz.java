package com.google.android.gms.internal.ads;

public final class rz extends yd<rz, sa> implements zzbcw {
    private static volatile zzbdf<rz> zzakh;
    private static final rz zzdiy = new rz();
    private int zzdit;

    static {
        yd.a(rz.class, zzdiy);
    }

    private rz() {
    }

    public static rz b() {
        return zzdiy;
    }

    public final int a() {
        return this.zzdit;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (sb.a[i - 1]) {
            case 1:
                return new rz();
            case 2:
                return new sa();
            case 3:
                Object[] objArr = new Object[]{"zzdit"};
                return yd.a(zzdiy, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\u000b", objArr);
            case 4:
                return zzdiy;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rz.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdiy);
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
