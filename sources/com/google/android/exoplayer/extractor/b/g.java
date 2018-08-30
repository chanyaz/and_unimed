package com.google.android.exoplayer.extractor.b;

import android.util.Log;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;
import java.util.Collections;

final class g extends d {
    private boolean b;
    private final k c;
    private final boolean[] d = new boolean[3];
    private final j e = new j(32, 128);
    private final j f = new j(33, 128);
    private final j g = new j(34, 128);
    private final j h = new j(39, 128);
    private final j i = new j(40, 128);
    private boolean j;
    private long k;
    private boolean l;
    private long m;
    private long n;
    private final i o = new i();

    public g(TrackOutput trackOutput, k kVar) {
        super(trackOutput);
        this.c = kVar;
    }

    private void a(int i) {
        if (!this.b) {
            this.e.a(i);
            this.f.a(i);
            this.g.a(i);
        }
        this.h.a(i);
        this.i.a(i);
    }

    private void a(long j, int i) {
        this.e.b(i);
        this.f.b(i);
        this.g.b(i);
        if (this.h.b(i)) {
            this.o.a(this.h.a, com.google.android.exoplayer.util.g.a(this.h.a, this.h.b));
            this.o.c(5);
            this.c.a(this.o, j, true);
        }
        if (this.i.b(i)) {
            this.o.a(this.i.a, com.google.android.exoplayer.util.g.a(this.i.a, this.i.b));
            this.o.c(5);
            this.c.a(this.o, j, true);
        }
    }

    private void a(j jVar, j jVar2, j jVar3) {
        int i;
        float f;
        Object obj = new byte[((jVar.b + jVar2.b) + jVar3.b)];
        System.arraycopy(jVar.a, 0, obj, 0, jVar.b);
        System.arraycopy(jVar2.a, 0, obj, jVar.b, jVar2.b);
        System.arraycopy(jVar3.a, 0, obj, jVar.b + jVar2.b, jVar3.b);
        com.google.android.exoplayer.util.g.a(jVar2.a, jVar2.b);
        h hVar = new h(jVar2.a);
        hVar.b(44);
        int c = hVar.c(3);
        hVar.b(1);
        hVar.b(88);
        hVar.b(8);
        int i2 = 0;
        for (i = 0; i < c; i++) {
            if (hVar.c(1) == 1) {
                i2 += 89;
            }
            if (hVar.c(1) == 1) {
                i2 += 8;
            }
        }
        hVar.b(i2);
        if (c > 0) {
            hVar.b((8 - c) * 2);
        }
        hVar.d();
        int d = hVar.d();
        if (d == 3) {
            hVar.b(1);
        }
        int d2 = hVar.d();
        int d3 = hVar.d();
        if (hVar.b()) {
            int d4 = hVar.d();
            int d5 = hVar.d();
            int d6 = hVar.d();
            int d7 = hVar.d();
            i = (d == 1 || d == 2) ? 2 : 1;
            d2 -= i * (d4 + d5);
            d3 -= (d == 1 ? 2 : 1) * (d6 + d7);
        }
        hVar.d();
        hVar.d();
        i = hVar.d();
        i2 = hVar.b() ? 0 : c;
        while (i2 <= c) {
            hVar.d();
            hVar.d();
            hVar.d();
            i2++;
        }
        hVar.d();
        hVar.d();
        hVar.d();
        hVar.d();
        hVar.d();
        hVar.d();
        if (hVar.b() && hVar.b()) {
            a(hVar);
        }
        hVar.b(2);
        if (hVar.b()) {
            hVar.b(4);
            hVar.d();
            hVar.d();
            hVar.b(1);
        }
        b(hVar);
        if (hVar.b()) {
            for (i2 = 0; i2 < hVar.d(); i2++) {
                hVar.b((i + 4) + 1);
            }
        }
        hVar.b(2);
        float f2 = 1.0f;
        if (hVar.b() && hVar.b()) {
            c = hVar.c(8);
            if (c == 255) {
                c = hVar.c(16);
                i = hVar.c(16);
                if (!(c == 0 || i == 0)) {
                    f2 = ((float) c) / ((float) i);
                }
                f = f2;
            } else if (c < com.google.android.exoplayer.util.g.b.length) {
                f = com.google.android.exoplayer.util.g.b[c];
            } else {
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + c);
            }
            this.a.format(k.a("video/hevc", -1, -1, d2, d3, f, Collections.singletonList(obj)));
            this.b = true;
        }
        f = 1.0f;
        this.a.format(k.a("video/hevc", -1, -1, d2, d3, f, Collections.singletonList(obj)));
        this.b = true;
    }

    private void a(h hVar) {
        int i = 0;
        while (i < 4) {
            for (int i2 = 0; i2 < 6; i2 = (i == 3 ? 3 : 1) + i2) {
                if (hVar.b()) {
                    int min = Math.min(64, 1 << ((i + 4) << 1));
                    if (i > 1) {
                        hVar.e();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        hVar.e();
                    }
                } else {
                    hVar.d();
                }
            }
            i++;
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (!this.b) {
            this.e.a(bArr, i, i2);
            this.f.a(bArr, i, i2);
            this.g.a(bArr, i, i2);
        }
        this.h.a(bArr, i, i2);
        this.i.a(bArr, i, i2);
    }

    public static boolean a(byte[] bArr, int i) {
        int c = com.google.android.exoplayer.util.g.c(bArr, i);
        return (c <= 9 || (c >= 16 && c <= 21)) && (bArr[i + 5] & 128) != 0;
    }

    private static void b(h hVar) {
        int d = hVar.d();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < d) {
            boolean b = i != 0 ? hVar.b() : z;
            int i3;
            if (b) {
                hVar.b(1);
                hVar.d();
                for (i3 = 0; i3 <= i2; i3++) {
                    if (hVar.b()) {
                        hVar.b(1);
                    }
                }
            } else {
                int d2 = hVar.d();
                int d3 = hVar.d();
                i2 = d2 + d3;
                for (i3 = 0; i3 < d2; i3++) {
                    hVar.d();
                    hVar.b(1);
                }
                for (i3 = 0; i3 < d3; i3++) {
                    hVar.d();
                    hVar.b(1);
                }
            }
            i++;
            z = b;
        }
    }

    private static boolean b(int i) {
        return i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21;
    }

    public void a() {
        this.c.a();
        com.google.android.exoplayer.util.g.a(this.d);
        this.e.a();
        this.f.a();
        this.g.a();
        this.h.a();
        this.i.a();
        this.j = false;
        this.k = 0;
    }

    public void a(i iVar, long j, boolean z) {
        while (iVar.b() > 0) {
            int d = iVar.d();
            int c = iVar.c();
            byte[] bArr = iVar.a;
            this.k += (long) iVar.b();
            this.a.sampleData(iVar, iVar.b());
            while (d < c) {
                int a = com.google.android.exoplayer.util.g.a(bArr, d, c, this.d);
                if (a < c) {
                    int i = a - d;
                    if (i > 0) {
                        a(bArr, d, a);
                    }
                    int c2 = com.google.android.exoplayer.util.g.c(bArr, a);
                    int i2 = c - a;
                    if (a(bArr, a)) {
                        if (this.j) {
                            if (this.l && !this.b && this.e.b() && this.f.b() && this.g.b()) {
                                a(this.e, this.f, this.g);
                            }
                            this.a.sampleMetadata(this.n, this.l ? 1 : 0, ((int) (this.k - this.m)) - i2, i2, null);
                        }
                        this.j = true;
                        this.m = this.k - ((long) i2);
                        this.n = j;
                        this.l = b(c2);
                    }
                    a(j, i < 0 ? -i : 0);
                    a(c2);
                    d = a + 3;
                } else {
                    a(bArr, d, c);
                    d = c;
                }
            }
        }
    }

    public void b() {
    }
}
