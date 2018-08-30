package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class kg {
    static final Charset a = Charset.forName("UTF-8");
    public static final byte[] b;
    private static final Charset c = Charset.forName("ISO-8859-1");
    private static final ByteBuffer d;
    private static final kd e;

    static {
        byte[] bArr = new byte[0];
        b = bArr;
        d = ByteBuffer.wrap(bArr);
        bArr = b;
        e = kd.a(bArr, 0, bArr.length, false);
    }

    static int a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
