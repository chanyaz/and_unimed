package com.google.android.gms.internal.ads;

public final class tx extends yd<tx, ty> implements zzbcw {
    private static volatile zzbdf<tx> zzakh;
    private static final tx zzdlp = new tx();
    private String zzdks = "";
    private String zzdll = "";
    private int zzdlm;
    private boolean zzdln;
    private String zzdlo = "";

    static {
        yd.a(tx.class, zzdlp);
    }

    private tx() {
    }

    private final void a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdll = str;
    }

    private final void a(boolean z) {
        this.zzdln = z;
    }

    private final void b(int i) {
        this.zzdlm = i;
    }

    private final void b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdks = str;
    }

    private final void c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzdlo = str;
    }

    public static ty f() {
        return (ty) ((ye) zzdlp.a(yi.e, null, null));
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (tz.a[i - 1]) {
            case 1:
                return new tx();
            case 2:
                return new ty();
            case 3:
                Object[] objArr = new Object[]{"zzdll", "zzdks", "zzdlm", "zzdln", "zzdlo"};
                return yd.a(zzdlp, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", objArr);
            case 4:
                return zzdlp;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (tx.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdlp);
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
        return this.zzdll;
    }

    public final String b() {
        return this.zzdks;
    }

    public final int c() {
        return this.zzdlm;
    }

    public final boolean d() {
        return this.zzdln;
    }

    public final String e() {
        return this.zzdlo;
    }
}
