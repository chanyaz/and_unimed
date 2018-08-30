package com.google.android.gms.internal.ads;

@zzadh
public final class akc {
    private static final Object a = new Object();
    private static akc b;
    private final kb c = new kb();
    private final ajt d = new ajt(new ajm(), new ajl(), new alo(), new apz(), new fe(), new n(), new aqa());
    private final String e = kb.c();
    private final amj f = new amj();
    private final amk g = new amk();
    private final aml h = new aml();

    static {
        akc akc = new akc();
        synchronized (a) {
            b = akc;
        }
    }

    protected akc() {
    }

    public static kb a() {
        return g().c;
    }

    public static ajt b() {
        return g().d;
    }

    public static String c() {
        return g().e;
    }

    public static amk d() {
        return g().g;
    }

    public static amj e() {
        return g().f;
    }

    public static aml f() {
        return g().h;
    }

    private static akc g() {
        akc akc;
        synchronized (a) {
            akc = b;
        }
        return akc;
    }
}
