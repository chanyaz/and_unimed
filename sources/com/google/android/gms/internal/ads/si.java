package com.google.android.gms.internal.ads;

public final class si extends yd<si, sj> implements zzbcw {
    private static volatile zzbdf<si> zzakh;
    private static final si zzdjb = new si();
    private int zzdih;
    private zzbah zzdip = zzbah.a;

    static {
        yd.a(si.class, zzdjb);
    }

    private si() {
    }

    public static si a(zzbah zzbah) {
        return (si) yd.a(zzdjb, zzbah);
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

    public static sj c() {
        return (sj) ((ye) zzdjb.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (sk.a[i - 1]) {
            case 1:
                return new si();
            case 2:
                return new sj();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdip"};
                return yd.a(zzdjb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n", objArr);
            case 4:
                return zzdjb;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (si.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdjb);
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

    public final zzbah b() {
        return this.zzdip;
    }
}
