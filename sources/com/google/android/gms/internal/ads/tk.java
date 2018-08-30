package com.google.android.gms.internal.ads;

public final class tk extends yd<tk, tl> implements zzbcw {
    private static volatile zzbdf<tk> zzakh;
    private static final tk zzdko = new tk();
    private int zzdir;
    private tn zzdkm;

    static {
        yd.a(tk.class, zzdko);
    }

    private tk() {
    }

    public static tk a(zzbah zzbah) {
        return (tk) yd.a(zzdko, zzbah);
    }

    public static tk c() {
        return zzdko;
    }

    public final tn a() {
        return this.zzdkm == null ? tn.c() : this.zzdkm;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (tm.a[i - 1]) {
            case 1:
                return new tk();
            case 2:
                return new tl();
            case 3:
                Object[] objArr = new Object[]{"zzdkm", "zzdir"};
                return yd.a(zzdko, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b", objArr);
            case 4:
                return zzdko;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (tk.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdko);
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
