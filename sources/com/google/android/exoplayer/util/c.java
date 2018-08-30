package com.google.android.exoplayer.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static final byte[] a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    private static final int[] b = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] c = new int[]{0, 1, 2, 3, 4, 5, 6, 8};

    private c() {
    }

    private static int a(byte[] bArr, int i) {
        int length = bArr.length - a.length;
        for (int i2 = i; i2 <= length; i2++) {
            if (b(bArr, i2)) {
                return i2;
            }
        }
        return -1;
    }

    public static Pair<Integer, Integer> a(byte[] bArr) {
        boolean z = true;
        int i = (bArr[0] >> 3) & 31;
        i = (i == 5 || i == 29) ? 1 : 0;
        int i2 = ((bArr[i] & 7) << 1) | ((bArr[i + 1] >> 7) & 1);
        if (i2 >= 13) {
            z = false;
        }
        b.b(z);
        return Pair.create(Integer.valueOf(b[i2]), Integer.valueOf((bArr[i + 1] >> 3) & 15));
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        Object obj = new byte[(a.length + i2)];
        System.arraycopy(a, 0, obj, 0, a.length);
        System.arraycopy(bArr, i, obj, a.length, i2);
        return obj;
    }

    private static boolean b(byte[] bArr, int i) {
        if (bArr.length - i <= a.length) {
            return false;
        }
        for (int i2 = 0; i2 < a.length; i2++) {
            if (bArr[i + i2] != a[i2]) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] b(byte[] bArr) {
        if (!b(bArr, 0)) {
            return (byte[][]) null;
        }
        List arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = a(bArr, i + a.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            Object obj = new byte[((i2 < arrayList.size() + -1 ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue)];
            System.arraycopy(bArr, intValue, obj, 0, obj.length);
            bArr2[i2] = obj;
            i2++;
        }
        return bArr2;
    }
}
