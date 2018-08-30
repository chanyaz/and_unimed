package com.google.android.gms.internal.ads;

import java.util.List;

public final class ua extends yd<ua, ub> implements zzbcw {
    private static volatile zzbdf<ua> zzakh;
    private static final ua zzdlt = new ua();
    private int zzdlq;
    private int zzdlr;
    private zzbbt<uc> zzdls = yd.i();

    static {
        yd.a(ua.class, zzdlt);
    }

    private ua() {
    }

    public static ua a(byte[] bArr) {
        return (ua) yd.a(zzdlt, bArr);
    }

    public final int a() {
        return this.zzdlr;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ue.a[i - 1]) {
            case 1:
                return new ua();
            case 2:
                return new ub();
            case 3:
                Object[] objArr = new Object[]{"zzdlq", "zzdlr", "zzdls", uc.class};
                return yd.a(zzdlt, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001\u000b\u0002\u001b", objArr);
            case 4:
                return zzdlt;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (ua.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdlt);
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

    public final List<uc> b() {
        return this.zzdls;
    }

    public final int c() {
        return this.zzdls.size();
    }
}
