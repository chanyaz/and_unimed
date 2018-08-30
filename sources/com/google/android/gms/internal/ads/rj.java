package com.google.android.gms.internal.ads;

public final class rj extends yd<rj, rk> implements zzbcw {
    private static volatile zzbdf<rj> zzakh;
    private static final rj zzdiq = new rj();
    private int zzdih;
    private rp zzdio;
    private zzbah zzdip = zzbah.a;

    static {
        yd.a(rj.class, zzdiq);
    }

    private rj() {
    }

    public static rj a(zzbah zzbah) {
        return (rj) yd.a(zzdiq, zzbah);
    }

    private final void a(rp rpVar) {
        if (rpVar == null) {
            throw new NullPointerException();
        }
        this.zzdio = rpVar;
    }

    private final void b(int i) {
        this.zzdih = i;
    }

    private final void b(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdip = zzbah;
    }

    public static rk d() {
        return (rk) ((ye) zzdiq.a(yi.e, null, null));
    }

    public static rj e() {
        return zzdiq;
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (rl.a[i - 1]) {
            case 1:
                return new rj();
            case 2:
                return new rk();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdio", "zzdip"};
                return yd.a(zzdiq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdiq;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rj.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdiq);
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

    public final rp b() {
        return this.zzdio == null ? rp.b() : this.zzdio;
    }

    public final zzbah c() {
        return this.zzdip;
    }
}
