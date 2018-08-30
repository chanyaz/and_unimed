package com.google.android.gms.internal.ads;

public final class uc extends yd<uc, ud> implements zzbcw {
    private static volatile zzbdf<uc> zzakh;
    private static final uc zzdlx = new uc();
    private int zzdlj;
    private zzaxi zzdlu;
    private int zzdlv;
    private int zzdlw;

    static {
        yd.a(uc.class, zzdlx);
    }

    private uc() {
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ue.a[i - 1]) {
            case 1:
                return new uc();
            case 2:
                return new ud();
            case 3:
                Object[] objArr = new Object[]{"zzdlu", "zzdlv", "zzdlw", "zzdlj"};
                return yd.a(zzdlx, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", objArr);
            case 4:
                return zzdlx;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uc.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdlx);
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

    public final boolean a() {
        return this.zzdlu != null;
    }

    public final zzaxi b() {
        return this.zzdlu == null ? zzaxi.e() : this.zzdlu;
    }

    public final zzaxl c() {
        zzaxl a = zzaxl.a(this.zzdlv);
        return a == null ? zzaxl.UNRECOGNIZED : a;
    }

    public final int d() {
        return this.zzdlw;
    }

    public final zzayd e() {
        zzayd a = zzayd.a(this.zzdlj);
        return a == null ? zzayd.UNRECOGNIZED : a;
    }
}
