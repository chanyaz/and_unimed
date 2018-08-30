package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaxi.zzb;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

final class qz implements zzaug<zzauk> {
    qz() {
    }

    private final zzauk a(zzbah zzbah) {
        try {
            th a = th.a(zzbah);
            if (a instanceof th) {
                a = a;
                wg.a(a.a(), 0);
                if (a.c().a() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                vz vzVar;
                a(a.b());
                zzaxa a2 = a.b().a();
                Key secretKeySpec = new SecretKeySpec(a.c().b(), "HMAC");
                int b = a.b().b();
                switch (ra.a[a2.ordinal()]) {
                    case 1:
                        vzVar = new vz("HMACSHA1", secretKeySpec, b);
                        break;
                    case 2:
                        vzVar = new vz("HMACSHA256", secretKeySpec, b);
                        break;
                    case 3:
                        vzVar = new vz("HMACSHA512", secretKeySpec, b);
                        break;
                    default:
                        throw new GeneralSecurityException("unknown hash");
                }
                return vzVar;
            }
            throw new GeneralSecurityException("expected HmacKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    private static void a(tn tnVar) {
        if (tnVar.b() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (ra.a[tnVar.a().ordinal()]) {
            case 1:
                if (tnVar.b() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 2:
                if (tnVar.b() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 3:
                if (tnVar.b() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    public final int getVersion() {
        return 0;
    }

    public final zzbcu zzb(zzbah zzbah) {
        try {
            return zzb(tk.a(zzbah));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    public final zzbcu zzb(zzbcu zzbcu) {
        if (zzbcu instanceof tk) {
            tk tkVar = (tk) zzbcu;
            if (tkVar.b() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            a(tkVar.a());
            return th.d().a(0).a(tkVar.a()).a(zzbah.a(wb.a(tkVar.b()))).c();
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    public final zzaxi zzc(zzbah zzbah) {
        return (zzaxi) zzaxi.d().a("type.googleapis.com/google.crypto.tink.HmacKey").a(((th) zzb(zzbah)).zzaav()).a(zzb.SYMMETRIC).c();
    }
}
