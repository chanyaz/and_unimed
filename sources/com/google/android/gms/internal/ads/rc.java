package com.google.android.gms.internal.ads;

public final class rc {
    public static final uy a = ((uy) uy.b().a("TINK_MAC_1_0_0").a(pu.a("TinkMac", "Mac", "HmacKey", 0, true)).c());
    private static final uy b = ((uy) ((uz) uy.b().a(a)).a("TINK_MAC_1_1_0").c());

    static {
        try {
            a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        qc.a("TinkMac", new rb());
    }
}
