package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.security.MessageDigest;
import javax.annotation.Nullable;

@Beta
public abstract class g {
    private static final char[] a = "0123456789abcdef".toCharArray();

    g() {
    }

    static g a(byte[] bArr) {
        return new h(bArr);
    }

    public abstract int a();

    public abstract int b();

    public abstract long c();

    public abstract byte[] d();

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return MessageDigest.isEqual(d(), ((g) obj).d());
    }

    public final int hashCode() {
        if (a() >= 32) {
            return b();
        }
        byte[] d = d();
        int i = d[0] & 255;
        for (int i2 = 1; i2 < d.length; i2++) {
            i |= (d[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] d = d();
        StringBuilder stringBuilder = new StringBuilder(d.length * 2);
        for (byte b : d) {
            stringBuilder.append(a[(b >> 4) & 15]).append(a[b & 15]);
        }
        return stringBuilder.toString();
    }
}
