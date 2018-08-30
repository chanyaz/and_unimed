package com.google.android.gms.internal.ads;

public final class rd extends yd<rd, re> implements zzbcw {
    private static volatile zzbdf<rd> zzakh;
    private static final rd zzdik = new rd();
    private int zzdih;
    private rj zzdii;
    private th zzdij;

    static {
        yd.a(rd.class, zzdik);
    }

    private rd() {
    }

    public static rd a(zzbah zzbah) {
        return (rd) yd.a(zzdik, zzbah);
    }

    private final void a(rj rjVar) {
        if (rjVar == null) {
            throw new NullPointerException();
        }
        this.zzdii = rjVar;
    }

    private final void a(th thVar) {
        if (thVar == null) {
            throw new NullPointerException();
        }
        this.zzdij = thVar;
    }

    private final void b(int i) {
        this.zzdih = i;
    }

    public static re d() {
        return (re) ((ye) zzdik.a(yi.e, null, null));
    }

    public final int a() {
        return this.zzdih;
    }

    protected final Object a(int i, Object obj, Object obj2) {
        switch (rf.a[i - 1]) {
            case 1:
                return new rd();
            case 2:
                return new re();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdii", "zzdij"};
                return yd.a(zzdik, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", objArr);
            case 4:
                return zzdik;
            case 5:
                zzbdf zzbdf = zzakh;
                if (zzbdf != null) {
                    return zzbdf;
                }
                Object obj3;
                synchronized (rd.class) {
                    obj3 = zzakh;
                    if (obj3 == null) {
                        obj3 = new yf(zzdik);
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

    public final rj b() {
        return this.zzdii == null ? rj.e() : this.zzdii;
    }

    public final th c() {
        return this.zzdij == null ? th.e() : this.zzdij;
    }
}
