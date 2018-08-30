package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

class qg implements zzaug<zzatz> {
    private static final Logger a = Logger.getLogger(qg.class.getName());

    qg() {
        qc.a("type.googleapis.com/google.crypto.tink.AesCtrKey", new qh());
    }

    private final zzatz a(zzbah zzbah) {
        try {
            rd a = rd.a(zzbah);
            if (a instanceof rd) {
                a = a;
                wg.a(a.a(), 0);
                return new vo((zzazi) qc.b("type.googleapis.com/google.crypto.tink.AesCtrKey", a.b()), (zzauk) qc.b("type.googleapis.com/google.crypto.tink.HmacKey", a.c()), a.c().b().b());
            }
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(rg.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof rg) {
            rg rgVar = (rg) zzbcu;
            return rd.d().a((rj) qc.a("type.googleapis.com/google.crypto.tink.AesCtrKey", rgVar.a())).a((th) qc.a("type.googleapis.com/google.crypto.tink.HmacKey", rgVar.b())).a(0).c();
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").a(((rd) zzb(zzbah)).zzaav()).a(zzb.SYMMETRIC).c();
    }
}
