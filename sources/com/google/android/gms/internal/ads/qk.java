package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

final class qk implements zzaug<zzatz> {
    qk() {
    }

    private static si a() {
        return (si) si.c().a(0).a(zzbah.a(wb.a(32))).c();
    }

    private final zzatz a(zzbah zzbah) {
        try {
            si a = si.a(zzbah);
            if (a instanceof si) {
                a = a;
                wg.a(a.a(), 0);
                if (a.b().a() == 32) {
                    return new vg(a.b().b());
                }
                throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
            }
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        return a();
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        return a();
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").a(a().zzaav()).a(zzb.SYMMETRIC).c();
    }
}
