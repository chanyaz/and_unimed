package com.google.android.gms.internal.ads;

public final class sf extends yd<sf, sg> implements zzbcw {
    private static volatile zzbdf<sf> zzakh;
    private static final sf zzdja = new sf();
    private int zzdir;

    static {
        yd.a(sf.class, zzdja);
    }

    private sf() {
    }

    public static sf a(zzbah zzbah) {
        return (sf) yd.a(zzdja, zzbah);
    }

    public final int a() {
        return this.zzdir;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (sh.a[i - 1]) {
            case 1:
                return new sf();
            case 2:
                return new sg();
            case 3:
                Object[] objArr = new Object[]{"zzdir"};
                return yd.a(zzdja, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0003\u0000\u0000\u0000\u0002\u000b", objArr);
            case 4:
                return zzdja;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (sf.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdja);
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
