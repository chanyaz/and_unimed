package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

final class qy implements zzayn {
    private final String a;
    private final int b;
    private sc c;
    private rd d;
    private int e;

    qy(tu tuVar) {
        this.a = tuVar.a();
        if (this.a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                sf a = sf.a(tuVar.b());
                this.c = (sc) qc.b(tuVar);
                this.b = a.a();
            } catch (Throwable e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                rg a2 = rg.a(tuVar.b());
                this.d = (rd) qc.b(tuVar);
                this.e = a2.a().b();
                this.b = a2.b().b() + this.e;
            } catch (Throwable e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else {
            String str = "unsupported AEAD DEM key type: ";
            String valueOf = String.valueOf(this.a);
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final zzatz zzi(byte[] bArr) {
        if (bArr.length != this.b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzatz) qc.b(this.a, (sc) ((sd) sc.c().a(this.c)).a(zzbah.a(bArr, 0, this.b)).c());
        } else if (this.a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.e);
            rj rjVar = (rj) ((rk) rj.d().a(this.d.b())).a(zzbah.a(copyOfRange)).c();
            return (zzatz) qc.b(this.a, (rd) rd.d().a(this.d.a()).a(rjVar).a((th) ((ti) th.d().a(this.d.c())).a(zzbah.a(Arrays.copyOfRange(bArr, this.e, this.b))).c()).c());
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }

    public final int zzwm() {
        return this.b;
    }
}
