package com.google.android.gms.internal.ads;

public final class rw extends yd<rw, rx> implements zzbcw {
    private static volatile zzbdf<rw> zzakh;
    private static final rw zzdix = new rw();
    private int zzdir;
    private rz zzdiv;

    static {
        yd.a(rw.class, zzdix);
    }

    private rw() {
    }

    public static rw a(zzbah zzbah) {
        return (rw) yd.a(zzdix, zzbah);
    }

    public final rz a() {
        return this.zzdiv == null ? rz.b() : this.zzdiv;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ry.a[i - 1]) {
            case 1:
                return new rw();
            case 2:
                return new rx();
            case 3:
                Object[] objArr = new Object[]{"zzdiv", "zzdir"};
                return yd.a(zzdix, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b", objArr);
            case 4:
                return zzdix;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rw.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdix);
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
