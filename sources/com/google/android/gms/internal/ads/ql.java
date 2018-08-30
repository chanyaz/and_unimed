package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

final class ql implements zzaug<zzatz> {
    ql() {
    }

    private static zzatz a(zzbah zzbah) {
        try {
            return a(uk.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    private static zzatz a(zzbcu zzbcu) {
        if (zzbcu instanceof uk) {
            uk ukVar = (uk) zzbcu;
            wg.a(ukVar.a(), 0);
            String a = ukVar.b().a();
            return py.a(a).zzdw(a);
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(un.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof un) {
            return uk.c().a((un) zzbcu).a(0).c();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.KmsAeadKey").a(((uk) zzb(zzbah)).zzaav()).a(zzb.REMOTE).c();
    }
}
