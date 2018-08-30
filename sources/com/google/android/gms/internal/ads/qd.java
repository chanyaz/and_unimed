package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class qd {
    private static final Charset a = Charset.forName("UTF-8");

    public static uf a(ua uaVar) {
        ye a = uf.a().a(uaVar.a());
        for (uc ucVar : uaVar.b()) {
            a.a((uh) uh.a().a(ucVar.b().a()).a(ucVar.c()).a(ucVar.e()).a(ucVar.d()).c());
        }
        return (uf) a.c();
    }

    public static void b(ua uaVar) {
        if (uaVar.c() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        int a = uaVar.a();
        int i = 1;
        int i2 = 0;
        for (uc ucVar : uaVar.b()) {
            if (!ucVar.a()) {
                throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(ucVar.d())}));
            } else if (ucVar.e() == zzayd.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(ucVar.d())}));
            } else if (ucVar.c() == zzaxl.UNKNOWN_STATUS) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(ucVar.d())}));
            } else {
                if (ucVar.c() == zzaxl.ENABLED && ucVar.d() == a) {
                    if (i2 != 0) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    i2 = 1;
                }
                i = ucVar.b().c() != zzb.ASYMMETRIC_PUBLIC ? 0 : i;
            }
        }
        if (i2 == 0 && i == 0) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
