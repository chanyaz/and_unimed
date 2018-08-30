package com.google.android.gms.internal.ads;

public final class uq extends yd<uq, ur> implements zzbcw {
    private static volatile zzbdf<uq> zzakh;
    private static final uq zzdmg = new uq();
    private int zzdih;
    private uu zzdmf;

    static {
        yd.a(uq.class, zzdmg);
    }

    private uq() {
    }

    public static uq a(zzbah zzbah) {
        return (uq) yd.a(zzdmg, zzbah);
    }

    private final void a(uu uuVar) {
        if (uuVar == null) {
            throw new NullPointerException();
        }
        this.zzdmf = uuVar;
    }

    private final void b(int i) {
        this.zzdih = i;
    }

    public static ur c() {
        return (ur) ((ye) zzdmg.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ut.a[i - 1]) {
            case 1:
                return new uq();
            case 2:
                return new ur();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdmf"};
                return yd.a(zzdmg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t", objArr);
            case 4:
                return zzdmg;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uq.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdmg);
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

    public final uu b() {
        return this.zzdmf == null ? uu.c() : this.zzdmf;
    }
}
