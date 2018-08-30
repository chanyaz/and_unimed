package com.google.android.gms.internal.ads;

public final class zzaxi extends yd<zzaxi, tq> implements zzbcw {
    private static volatile zzbdf<zzaxi> zzakh;
    private static final zzaxi zzdkv = new zzaxi();
    private String zzdks = "";
    private zzbah zzdkt = zzbah.a;
    private int zzdku;

    public enum zzb implements zzbbr {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzbbs<zzb> g = null;
        private final int h;

        static {
            g = new ts();
        }

        private zzb(int i) {
            this.h = i;
        }

        public static zzb a(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        public final int zzhq() {
            if (this != UNRECOGNIZED) {
                return this.h;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        yd.a(zzaxi.class, zzdkv);
    }

    private zzaxi() {
    }

    private final void a(zzb zzb) {
        if (zzb == null) {
            throw new NullPointerException();
        }
        this.zzdku = zzb.zzhq();
    }

    private final void a(zzbah zzbah) {
        if (zzbah == null) {
            throw new NullPointerException();
        }
        this.zzdkt = zzbah;
    }

    private final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdks = str;
    }

    public static tq d() {
        return (tq) ((ye) zzdkv.a(yi.e, null, null));
    }

    public static zzaxi e() {
        return zzdkv;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (tr.a[i - 1]) {
            case 1:
                return new zzaxi();
            case 2:
                return new tq();
            case 3:
                Object[] objArr = new Object[]{"zzdks", "zzdkt", "zzdku"};
                return yd.a(zzdkv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", objArr);
            case 4:
                return zzdkv;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (zzaxi.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdkv);
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

    public final zzb c() {
        zzb a = zzb.a(this.zzdku);
        return a == null ? zzb.UNRECOGNIZED : a;
    }
}
