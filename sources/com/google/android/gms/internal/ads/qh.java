package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

final class qh implements zzaug<zzazi> {
    qh() {
    }

    private final vb a(zzbah zzbah) {
        try {
            rj a = rj.a(zzbah);
            if (a instanceof rj) {
                a = a;
                wg.a(a.a(), 0);
                wg.a(a.c().a());
                a(a.b());
                return new vb(a.c().b(), a.b().a());
            }
            throw new GeneralSecurityException("expected AesCtrKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e);
        }
    }

    private static void a(rp rpVar) {
        if (rpVar.a() < 12 || rpVar.a() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(rm.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof rm) {
            rm rmVar = (rm) zzbcu;
            wg.a(rmVar.b());
            a(rmVar.a());
            return rj.d().a(rmVar.a()).a(zzbah.a(wb.a(rmVar.b()))).a(0).c();
        }
        throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.AesCtrKey").a(((rj) zzb(zzbah)).zzaav()).a(zzb.SYMMETRIC).c();
    }
}
