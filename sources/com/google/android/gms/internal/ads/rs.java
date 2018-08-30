package com.google.android.gms.internal.ads;

public final class rs extends yd<rs, rt> implements zzbcw {
    private static volatile zzbdf<rs> zzakh;
    private static final rs zzdiw = new rs();
    private int zzdih;
    private zzbah zzdip = zzbah.a;
    private rz zzdiv;

    static {
        yd.a(rs.class, zzdiw);
    }

    private rs() {
    }

    public static rs a(zzbah zzbah) {
        return (rs) yd.a(zzdiw, zzbah);
    }

    private final void a(rz rzVar) {
        if (rzVar == null) {
            throw new NullPointerException();
        }
        this.zzdiv = rzVar;
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

    public static rt d() {
        return (rt) ((ye) zzdiw.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (ru.a[i - 1]) {
            case 1:
                return new rs();
            case 2:
                return new rt();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdiv", "zzdip"};
                return yd.a(zzdiw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdiw;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rs.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdiw);
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

    public final rz b() {
        return this.zzdiv == null ? rz.b() : this.zzdiv;
    }

    public final zzbah c() {
        return this.zzdip;
    }
}
