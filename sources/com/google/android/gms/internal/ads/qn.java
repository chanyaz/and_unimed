package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

final class qn implements zzaug<zzatz> {
    qn() {
    }

    private final zzatz a(zzbah zzbah) {
        try {
            uq a = uq.a(zzbah);
            if (a instanceof uq) {
                a = a;
                wg.a(a.a(), 0);
                String a2 = a.b().a();
                return new qm(a.b().b(), py.a(a2).zzdw(a2));
            }
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(uu.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof uu) {
            return uq.c().a((uu) zzbcu).a(0).c();
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").a(((uq) zzb(zzbah)).zzaav()).a(zzb.REMOTE).c();
    }
}
