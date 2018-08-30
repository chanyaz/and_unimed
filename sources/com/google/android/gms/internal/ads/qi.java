package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

final class qi implements zzaug<zzatz> {
    qi() {
    }

    private final zzatz a(zzbah zzbah) {
        try {
            rs a = rs.a(zzbah);
            if (a instanceof rs) {
                a = a;
                wg.a(a.a(), 0);
                wg.a(a.c().a());
                if (a.b().a() == 12 || a.b().a() == 16) {
                    return new vc(a.c().b(), a.b().a());
                }
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
            throw new GeneralSecurityException("expected AesEaxKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(rw.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof rw) {
            rw rwVar = (rw) zzbcu;
            wg.a(rwVar.b());
            if (rwVar.a().a() == 12 || rwVar.a().a() == 16) {
                return rs.d().a(zzbah.a(wb.a(rwVar.b()))).a(rwVar.a()).a(0).c();
            }
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.AesEaxKey").a(((rs) zzb(zzbah)).zzaav()).a(zzb.SYMMETRIC).c();
    }
}
