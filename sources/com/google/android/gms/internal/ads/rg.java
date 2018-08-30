package com.google.android.gms.internal.ads;

public final class rg extends yd<rg, rh> implements zzbcw {
    private static volatile zzbdf<rg> zzakh;
    private static final rg zzdin = new rg();
    private rm zzdil;
    private tk zzdim;

    static {
        yd.a(rg.class, zzdin);
    }

    private rg() {
    }

    public static rg a(zzbah zzbah) {
        return (rg) yd.a(zzdin, zzbah);
    }

    public final rm a() {
        return this.zzdil == null ? rm.c() : this.zzdil;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ri.a[i - 1]) {
            case 1:
                return new rg();
            case 2:
                return new rh();
            case 3:
                Object[] objArr = new Object[]{"zzdil", "zzdim"};
                return yd.a(zzdin, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\t", objArr);
            case 4:
                return zzdin;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rg.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdin);
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

    public final tk b() {
        return this.zzdim == null ? tk.c() : this.zzdim;
    }
}
