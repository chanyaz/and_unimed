package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class vd implements zzatz {
    private final SecretKey a;

    public vd(byte[] bArr) {
        this.a = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Object obj = new byte[((bArr.length + 12) + 16)];
        Object a = wb.a(12);
        System.arraycopy(a, 0, obj, 0, 12);
        Cipher cipher = (Cipher) vp.a.a("AES/GCM/NoPadding");
        cipher.init(1, this.a, new GCMParameterSpec(128, a));
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        cipher.updateAAD(bArr2);
        cipher.doFinal(bArr, 0, bArr.length, obj, 12);
        return obj;
    }
}
