package com.google.android.gms.internal.ads;

public final class sv extends yd<sv, sw> implements zzbcw {
    private static volatile zzbdf<sv> zzakh;
    private static final sv zzdjq = new sv();
    private int zzdih;
    private zzbah zzdip = zzbah.a;
    private sy zzdjp;

    static {
        yd.a(sv.class, zzdjq);
    }

    private sv() {
    }

    public static sv a(zzbah zzbah) {
        return (sv) yd.a(zzdjq, zzbah);
    }

    private final void a(sy syVar) {
        if (syVar == null) {
            throw new NullPointerException();
        }
        this.zzdjp = syVar;
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

    public static sw d() {
        return (sw) ((ye) zzdjq.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (sx.a[i - 1]) {
            case 1:
                return new sv();
            case 2:
                return new sw();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdjp", "zzdip"};
                return yd.a(zzdjq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdjq;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (sv.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdjq);
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

    public final sy b() {
        return this.zzdjp == null ? sy.f() : this.zzdjp;
    }

    public final zzbah c() {
        return this.zzdip;
    }
}
