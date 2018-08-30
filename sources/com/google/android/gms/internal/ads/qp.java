package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;

final class qp implements zzaug<zzaue> {
    qp() {
    }

    private final zzaue a(zzbah zzbah) {
        try {
            sv a = sv.a(zzbah);
            if (a instanceof sv) {
                a = a;
                wg.a(a.a(), 0);
                qw.a(a.b().b());
                ss b = a.b().b();
                tb a2 = b.a();
                zzayv a3 = qw.a(a2.a());
                byte[] b2 = a.c().b();
                return new vh((ECPrivateKey) ((KeyFactory) vp.e.a("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, b2), vm.a(a3))), a2.c().b(), qw.a(a2.b()), qw.a(b.c()), new qy(b.b().a()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(sp.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof sp) {
            sp spVar = (sp) zzbcu;
            qw.a(spVar.a());
            KeyPair a = vm.a(vm.a(qw.a(spVar.a().a().a())));
            ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
            ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
            ECPoint w = eCPublicKey.getW();
            return sv.d().a(0).a((sy) sy.e().a(0).a(spVar.a()).a(zzbah.a(w.getAffineX().toByteArray())).b(zzbah.a(w.getAffineY().toByteArray())).c()).a(zzbah.a(eCPrivateKey.getS().toByteArray())).c();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").a(((sv) zzb(zzbah)).zzaav()).a(zzb.ASYMMETRIC_PRIVATE).c();
    }
}
