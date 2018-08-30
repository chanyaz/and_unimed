package com.google.android.gms.internal.ads;

public final class qf {
    public static final uy a = ((uy) ((uz) uy.b().a(rc.a)).a(pu.a("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).a(pu.a("TinkAead", "Aead", "AesEaxKey", 0, true)).a(pu.a("TinkAead", "Aead", "AesGcmKey", 0, true)).a(pu.a("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).a(pu.a("TinkAead", "Aead", "KmsAeadKey", 0, true)).a(pu.a("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).a("TINK_AEAD_1_0_0").c());
    private static final uy b = ((uy) ((uz) uy.b().a(a)).a("TINK_AEAD_1_1_0").c());

    static {
        try {
            a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        qc.a("TinkAead", new qe());
        rc.a();
    }
}
