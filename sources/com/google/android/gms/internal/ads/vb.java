package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class vb implements zzazi {
    private final SecretKeySpec a;
    private final int b;
    private final int c = ((Cipher) vp.a.a("AES/CTR/NoPadding")).getBlockSize();

    public vb(byte[] bArr, int i) {
        this.a = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.c) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.b = i;
    }

    public final byte[] zzk(byte[] bArr) {
        if (bArr.length > MoPubClientPositioning.NO_REPEAT - this.b) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (MoPubClientPositioning.NO_REPEAT - this.b));
        }
        Object obj = new byte[(this.b + bArr.length)];
        Object a = wb.a(this.b);
        System.arraycopy(a, 0, obj, 0, this.b);
        int length = bArr.length;
        int i = this.b;
        Cipher cipher = (Cipher) vp.a.a("AES/CTR/NoPadding");
        Object obj2 = new byte[this.c];
        System.arraycopy(a, 0, obj2, 0, this.b);
        cipher.init(1, this.a, new IvParameterSpec(obj2));
        if (cipher.doFinal(bArr, 0, length, obj, i) == length) {
            return obj;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
