package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class ve {
    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static byte[] a(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (i > MoPubClientPositioning.NO_REPEAT - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i += bArr2.length;
        }
        Object obj = new byte[i];
        i = 0;
        for (Object obj2 : bArr) {
            System.arraycopy(obj2, 0, obj, i, obj2.length);
            i += obj2.length;
        }
        return obj;
    }
}
