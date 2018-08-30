package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class vf extends wd {
    private static final byte[] c = new byte[16];

    vf(byte[] bArr, int i) {
        super(bArr, i);
    }

    private static void a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = wd.a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = wd.a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = wd.a(iArr[i4] ^ iArr[i], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = wd.a(iArr[i2] ^ iArr[i3], 7);
    }

    final int a() {
        return 12;
    }

    final ByteBuffer a(byte[] bArr, int i) {
        int i2;
        Object obj = new int[16];
        System.arraycopy(wd.a, 0, obj, 0, a.length);
        Object a = wd.a(ByteBuffer.wrap(this.b.a()));
        System.arraycopy(a, 0, obj, 4, a.length);
        obj[12] = i;
        System.arraycopy(wd.a(ByteBuffer.wrap(bArr)), 0, obj, 13, 3);
        int[] iArr = (int[]) obj.clone();
        for (i2 = 0; i2 < 10; i2++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
        for (i2 = 0; i2 < 16; i2++) {
            obj[i2] = obj[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(obj, 0, 16);
        return order;
    }
}
