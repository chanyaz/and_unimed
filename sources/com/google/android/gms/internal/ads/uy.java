package com.google.android.gms.internal.ads;

import java.util.List;

public final class uy extends yd<uy, uz> implements zzbcw {
    private static volatile zzbdf<uy> zzakh;
    private static final uy zzdmt = new uy();
    private int zzdlq;
    private String zzdmr = "";
    private zzbbt<tx> zzdms = yd.i();

    static {
        yd.a(uy.class, zzdmt);
    }

    private uy() {
    }

    private final void a(tx txVar) {
        if (txVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzdms.zzaay()) {
            zzbbt zzbbt = this.zzdms;
            int size = zzbbt.size();
            this.zzdms = zzbbt.zzbm(size == 0 ? 10 : size << 1);
        }
        this.zzdms.add(txVar);
    }

    private final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdmr = str;
    }

    public static uz b() {
        return (uz) ((ye) zzdmt.a(yi.e, null, null));
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (va.a[i - 1]) {
            case 1:
                return new uy();
            case 2:
                return new uz();
            case 3:
                Object[] objArr = new Object[]{"zzdlq", "zzdmr", "zzdms", tx.class};
                return yd.a(zzdmt, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", objArr);
            case 4:
                return zzdmt;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uy.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdmt);
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

    public final List<tx> a() {
        return this.zzdms;
    }
}
