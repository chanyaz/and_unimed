package com.google.android.gms.internal.ads;

public final class tu extends yd<tu, tv> implements zzbcw {
    private static volatile zzbdf<tu> zzakh;
    private static final tu zzdlk = new tu();
    private String zzdks = "";
    private zzbah zzdkt = zzbah.a;
    private int zzdlj;

    static {
        yd.a(tu.class, zzdlk);
    }

    private tu() {
    }

    public static tu c() {
        return zzdlk;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (tw.a[i - 1]) {
            case 1:
                return new tu();
            case 2:
                return new tv();
            case 3:
                Object[] objArr = new Object[]{"zzdks", "zzdkt", "zzdlj"};
                return yd.a(zzdlk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", objArr);
            case 4:
                return zzdlk;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (tu.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdlk);
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

    public final String a() {
        return this.zzdks;
    }

    public final zzbah b() {
        return this.zzdkt;
    }
}
