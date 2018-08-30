package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;

public final class pz {
    @Deprecated
    public static final px a(byte[] bArr) {
        try {
            ua a = ua.a(bArr);
            for (uc ucVar : a.b()) {
                if (ucVar.b().c() == zzb.UNKNOWN_KEYMATERIAL || ucVar.b().c() == zzb.SYMMETRIC) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                } else if (ucVar.b().c() == zzb.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return px.a(a);
        } catch (zzbbu e) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
