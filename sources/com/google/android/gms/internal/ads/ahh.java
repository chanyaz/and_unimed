package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ahh extends agz {
    private MessageDigest b;
    private final int c;
    private final int d;

    public ahh(int i) {
        int i2 = i / 8;
        if (i % 8 > 0) {
            i2++;
        }
        this.c = i2;
        this.d = i;
    }

    public final byte[] a(String str) {
        byte[] bArr;
        synchronized (this.a) {
            this.b = a();
            if (this.b == null) {
                bArr = new byte[0];
            } else {
                this.b.reset();
                this.b.update(str.getBytes(Charset.forName("UTF-8")));
                Object digest = this.b.digest();
                bArr = new byte[(digest.length > this.c ? this.c : digest.length)];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
                if (this.d % 8 > 0) {
                    int i;
                    long j = 0;
                    for (i = 0; i < bArr.length; i++) {
                        if (i > 0) {
                            j <<= 8;
                        }
                        j += (long) (bArr[i] & 255);
                    }
                    j >>>= 8 - (this.d % 8);
                    for (i = this.c - 1; i >= 0; i--) {
                        bArr[i] = (byte) ((int) (255 & j));
                        j >>>= 8;
                    }
                }
            }
        }
        return bArr;
    }
}
