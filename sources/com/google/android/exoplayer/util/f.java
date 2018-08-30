package com.google.android.exoplayer.util;

public final class f {
    private static final String[] h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] i = new int[]{44100, 48000, 32000};
    private static final int[] j = new int[]{32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448};
    private static final int[] k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
    private static final int[] m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    private static final int[] n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static int a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 == 0 || i4 == 15) {
            return -1;
        }
        int i5 = (i >>> 10) & 3;
        if (i5 == 3) {
            return -1;
        }
        int i6 = i[i5];
        i5 = i2 == 2 ? i6 / 2 : i2 == 0 ? i6 / 4 : i6;
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? j[i4 - 1] : k[i4 - 1]) * 12000) / i5) + i7) * 4;
        }
        if (i2 == 3) {
            i4 = i3 == 2 ? l[i4 - 1] : m[i4 - 1];
        } else {
            i4 = n[i4 - 1];
        }
        if (i2 == 3) {
            return ((144000 * i4) / i5) + i7;
        }
        return (((i3 == 1 ? 72000 : 144000) * i4) / i5) + i7;
    }

    private void a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
    }

    public static boolean a(int i, f fVar) {
        int i2 = 2;
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i3 = (i >>> 19) & 3;
        if (i3 == 1) {
            return false;
        }
        int i4 = (i >>> 17) & 3;
        if (i4 == 0) {
            return false;
        }
        int i5 = (i >>> 12) & 15;
        if (i5 == 0 || i5 == 15) {
            return false;
        }
        int i6 = (i >>> 10) & 3;
        if (i6 == 3) {
            return false;
        }
        int i7;
        int i8;
        i6 = i[i6];
        if (i3 == 2) {
            i6 /= 2;
        } else if (i3 == 0) {
            i6 /= 4;
        }
        int i9 = (i >>> 9) & 1;
        int i10;
        if (i4 == 3) {
            i10 = i3 == 3 ? j[i5 - 1] : k[i5 - 1];
            i5 = (((i10 * 12000) / i6) + i9) * 4;
            i7 = 384;
            i8 = i10;
        } else if (i3 == 3) {
            i10 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
            i7 = 1152;
            i5 = ((144000 * i10) / i6) + i9;
            i8 = i10;
        } else {
            i8 = n[i5 - 1];
            i7 = i4 == 1 ? 576 : 1152;
            i5 = (((i4 == 1 ? 72000 : 144000) * i8) / i6) + i9;
        }
        String str = h[3 - i4];
        if (((i >> 6) & 3) == 3) {
            i2 = 1;
        }
        fVar.a(i3, str, i5, i6, i2, i8, i7);
        return true;
    }
}
