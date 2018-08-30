package com.google.android.gms.internal.ads;

public final class uh extends yd<uh, ui> implements zzbcw {
    private static volatile zzbdf<uh> zzakh;
    private static final uh zzdma = new uh();
    private String zzdks = "";
    private int zzdlj;
    private int zzdlv;
    private int zzdlw;

    static {
        yd.a(uh.class, zzdma);
    }

    private uh() {
    }

    public static ui a() {
        return (ui) ((ye) zzdma.a(yi.e, null, null));
    }

    private final void a(zzaxl zzaxl) {
        if (zzaxl == null) {
            throw new NullPointerException();
        }
        this.zzdlv = zzaxl.zzhq();
    }

    private final void a(zzayd zzayd) {
        if (zzayd == null) {
            throw new NullPointerException();
        }
        this.zzdlj = zzayd.zzhq();
    }

    private final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdks = str;
    }

    private final void b(int i) {
        this.zzdlw = i;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (uj.a[i - 1]) {
            case 1:
                return new uh();
            case 2:
                return new ui();
            case 3:
                Object[] objArr = new Object[]{"zzdks", "zzdlv", "zzdlw", "zzdlj"};
                return yd.a(zzdma, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", objArr);
            case 4:
                return zzdma;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (uh.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdma);
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
