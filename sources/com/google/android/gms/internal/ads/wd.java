package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class wd implements zzazi {
    static final int[] a = a(ByteBuffer.wrap(new byte[]{(byte) 101, (byte) 120, (byte) 112, (byte) 97, (byte) 110, (byte) 100, (byte) 32, (byte) 51, (byte) 50, (byte) 45, (byte) 98, (byte) 121, (byte) 116, (byte) 101, (byte) 32, (byte) 107}));
    final vy b;
    private final int c;

    wd(byte[] bArr, int i) {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.b = vy.a(bArr);
        this.c = i;
    }

    static int a(int i, int i2) {
        return (i << i2) | (i >>> (-i2));
    }

    static int[] a(ByteBuffer byteBuffer) {
        IntBuffer asIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    abstract int a();

    abstract ByteBuffer a(byte[] bArr, int i);

    final void a(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] a = wb.a(a());
        byteBuffer.put(a);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int remaining = wrap.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer a2 = a(a, this.c + i2);
            if (i2 == i - 1) {
                ve.a(byteBuffer, wrap, a2, remaining % 64);
            } else {
                ve.a(byteBuffer, wrap, a2, 64);
            }
        }
    }

    public final byte[] zzk(byte[] bArr) {
        int length = bArr.length;
        a();
        if (length > 2147483635) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
        a(allocate, bArr);
        return allocate.array();
    }
}
