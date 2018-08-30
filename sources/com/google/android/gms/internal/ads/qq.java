package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class qq implements zzaug<zzauf> {
    qq() {
    }

    private final zzauf a(zzbah zzbah) {
        try {
            sy a = sy.a(zzbah);
            if (a instanceof sy) {
                a = a;
                wg.a(a.a(), 0);
                qw.a(a.b());
                ss b = a.b();
                tb a2 = b.a();
                return new vi(vm.a(qw.a(a2.a()), a.c().b(), a.d().b()), a2.c().b(), qw.a(a2.b()), qw.a(b.c()), new qy(b.b().a()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        throw new GeneralSecurityException("Not implemented.");
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        throw new GeneralSecurityException("Not implemented.");
    }

    public final zzaxi zzc(zzbah zzbah) {
        throw new GeneralSecurityException("Not implemented.");
    }
}
