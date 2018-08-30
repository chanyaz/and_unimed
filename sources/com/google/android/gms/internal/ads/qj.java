package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

final class qj implements zzaug<zzatz> {
    qj() {
    }

    private final zzatz a(zzbah zzbah) {
        try {
            sc a = sc.a(zzbah);
            if (a instanceof sc) {
                a = a;
                wg.a(a.a(), 0);
                wg.a(a.b().a());
                return new vd(a.b().b());
            }
            throw new GeneralSecurityException("expected AesGcmKey proto");
        } catch (zzbbu e) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(sf.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof sf) {
            sf sfVar = (sf) zzbcu;
            wg.a(sfVar.a());
            return sc.c().a(zzbah.a(wb.a(sfVar.a()))).a(0).c();
        }
        throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.AesGcmKey").a(((sc) zzb(zzbah)).zzaav()).a(zzb.SYMMETRIC).c();
    }
}
