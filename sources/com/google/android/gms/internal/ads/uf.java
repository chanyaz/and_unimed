package com.google.android.gms.internal.ads;

public final class uf extends yd<uf, ug> implements zzbcw {
    private static volatile zzbdf<uf> zzakh;
    private static final uf zzdlz = new uf();
    private int zzdlq;
    private int zzdlr;
    private zzbbt<uh> zzdly = yd.i();

    static {
        yd.a(uf.class, zzdlz);
    }

    private uf() {
    }

    public static ug a() {
        return (ug) ((ye) zzdlz.a(yi.e, null, null));
    }

    private final void a(uh uhVar) {
        if (uhVar == null) {
            throw new NullPointerException();
        }
        if (!this.zzdly.zzaay()) {
            zzbbt zzbbt = this.zzdly;
            int size = zzbbt.size();
            this.zzdly = zzbbt.zzbm(size == 0 ? 10 : size << 1);
        }
        this.zzdly.add(uhVar);
    }

    private final void b(int i) {
        this.zzdlr = i;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (uj.a[i - 1]) {
            case 1:
                return new uf();
            case 2:
                return new ug();
            case 3:
                Object[] objArr = new Object[]{"zzdlq", "zzdlr", "zzdly", uh.class};
                return yd.a(zzdlz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001\u000b\u0002\u001b", objArr);
            case 4:
                return zzdlz;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uf.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdlz);
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
}
