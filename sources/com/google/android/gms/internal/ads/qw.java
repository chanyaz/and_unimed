package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class qw {
    public static zzayv a(zzawy zzawy) {
        switch (qx.b[zzawy.ordinal()]) {
            case 1:
                return zzayv.NIST_P256;
            case 2:
                return zzayv.NIST_P384;
            case 3:
                return zzayv.NIST_P521;
            default:
                String valueOf = String.valueOf(zzawy);
                throw new GeneralSecurityException(new StringBuilder(String.valueOf(valueOf).length() + 20).append("unknown curve type: ").append(valueOf).toString());
        }
    }

    public static zzayw a(zzawk zzawk) {
        switch (qx.c[zzawk.ordinal()]) {
            case 1:
                return zzayw.UNCOMPRESSED;
            case 2:
                return zzayw.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzawk);
                throw new GeneralSecurityException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("unknown point format: ").append(valueOf).toString());
        }
    }

    public static String a(zzaxa zzaxa) {
        switch (qx.a[zzaxa.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzaxa);
                throw new NoSuchAlgorithmException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("hash unsupported for HMAC: ").append(valueOf).toString());
        }
    }

    public static void a(ss ssVar) {
        vm.a(a(ssVar.a().a()));
        a(ssVar.a().b());
        if (ssVar.c() == zzawk.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        qc.a(ssVar.b().a());
    }
}
