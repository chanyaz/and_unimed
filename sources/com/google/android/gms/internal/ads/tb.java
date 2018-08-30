package com.google.android.gms.internal.ads;

public final class tb extends yd<tb, tc> implements zzbcw {
    private static volatile zzbdf<tb> zzakh;
    private static final tb zzdjx = new tb();
    private int zzdju;
    private int zzdjv;
    private zzbah zzdjw = zzbah.a;

    static {
        yd.a(tb.class, zzdjx);
    }

    private tb() {
    }

    public static tb d() {
        return zzdjx;
    }

    public final zzawy a() {
        zzawy a = zzawy.a(this.zzdju);
        return a == null ? zzawy.UNRECOGNIZED : a;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (td.a[i - 1]) {
            case 1:
                return new tb();
            case 2:
                return new tc();
            case 3:
                Object[] objArr = new Object[]{"zzdju", "zzdjv", "zzdjw"};
                return yd.a(zzdjx, "\u0000\u0003\u0000\u0000\u0001\u000b\u000b\f\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", objArr);
            case 4:
                return zzdjx;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (tb.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdjx);
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

    public final zzaxa b() {
        zzaxa a = zzaxa.a(this.zzdjv);
        return a == null ? zzaxa.UNRECOGNIZED : a;
    }

    public final zzbah c() {
        return this.zzdjw;
    }
}
