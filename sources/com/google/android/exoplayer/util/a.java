package com.google.android.exoplayer.util;

import com.google.android.exoplayer.k;

public final class a {
    private static final int[] a = new int[]{48000, 44100, 32000};
    private static final int[] b = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] c = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] d = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    private a() {
    }

    public static int a(int i, int i2) {
        return (((i * 8) * i2) + 768000) / 1536000;
    }

    public static k a(h hVar) {
        int i = 1;
        hVar.b(32);
        int c = hVar.c(2);
        hVar.b(14);
        int c2 = hVar.c(3);
        if (!((c2 & 1) == 0 || c2 == 1)) {
            hVar.b(2);
        }
        if ((c2 & 4) != 0) {
            hVar.b(2);
        }
        if (c2 == 2) {
            hVar.b(2);
        }
        boolean b = hVar.b();
        String str = "audio/ac3";
        c2 = b[c2];
        if (!b) {
            i = 0;
        }
        return k.a(str, -1, i + c2, a[c], null);
    }

    public static k a(i iVar) {
        int i = a[(iVar.f() & 192) >> 6];
        int f = iVar.f();
        int i2 = b[(f & 56) >> 3];
        if ((f & 4) != 0) {
            i2++;
        }
        return k.a("audio/ac3", -1, i2, i, null);
    }

    public static int b(h hVar) {
        hVar.b(32);
        int c = hVar.c(2);
        int c2 = hVar.c(6);
        c = a[c];
        int i = c[c2 / 2];
        return c == 32000 ? i * 6 : c == 44100 ? (d[c2 / 2] + (c2 % 2)) * 2 : i * 4;
    }

    public static k b(i iVar) {
        iVar.c(2);
        int i = a[(iVar.f() & 192) >> 6];
        int f = iVar.f();
        int i2 = b[(f & 14) >> 1];
        if ((f & 1) != 0) {
            i2++;
        }
        return k.a("audio/eac3", -1, i2, i, null);
    }
}
