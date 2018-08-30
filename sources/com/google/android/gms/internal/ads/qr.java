package com.google.android.gms.internal.ads;

public final class qr {
    public static final uy a = ((uy) ((uz) uy.b().a(qf.a)).a(pu.a("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).a(pu.a("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).a("TINK_HYBRID_1_0_0").c());
    private static final uy b = ((uy) ((uz) uy.b().a(a)).a("TINK_HYBRID_1_1_0").c());

    static {
        try {
            qc.a("TinkHybridEncrypt", new qt());
            qc.a("TinkHybridDecrypt", new qs());
            qf.a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
