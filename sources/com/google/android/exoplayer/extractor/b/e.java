package com.google.android.exoplayer.extractor.b;

import android.util.Log;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.g;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;
import java.util.ArrayList;
import java.util.List;

final class e extends d {
    private boolean b;
    private final k c;
    private final boolean[] d = new boolean[3];
    private final f e;
    private final j f;
    private final j g;
    private final j h;
    private boolean i;
    private long j;
    private boolean k;
    private long l;
    private long m;
    private final i n;

    public e(TrackOutput trackOutput, k kVar, boolean z) {
        super(trackOutput);
        this.c = kVar;
        this.e = z ? null : new f();
        this.f = new j(7, 128);
        this.g = new j(8, 128);
        this.h = new j(6, 128);
        this.n = new i();
    }

    private void a(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
        if (!this.b) {
            this.f.a(i);
            this.g.a(i);
        }
        this.h.a(i);
    }

    private void a(long j, int i) {
        this.f.b(i);
        this.g.b(i);
        if (this.h.b(i)) {
            this.n.a(this.h.a, g.a(this.h.a, this.h.b));
            this.n.b(4);
            this.c.a(this.n, j, true);
        }
    }

    private void a(j jVar, j jVar2) {
        int d;
        int i;
        float f;
        Object obj = new byte[jVar.b];
        Object obj2 = new byte[jVar2.b];
        System.arraycopy(jVar.a, 0, obj, 0, jVar.b);
        System.arraycopy(jVar2.a, 0, obj2, 0, jVar2.b);
        List arrayList = new ArrayList();
        arrayList.add(obj);
        arrayList.add(obj2);
        g.a(jVar.a, jVar.b);
        h hVar = new h(jVar.a);
        hVar.b(32);
        int c = hVar.c(8);
        hVar.b(16);
        hVar.d();
        int i2 = 1;
        if (c == 100 || c == 110 || c == 122 || c == 244 || c == 44 || c == 83 || c == 86 || c == 118 || c == 128 || c == 138) {
            d = hVar.d();
            if (d == 3) {
                hVar.b(1);
            }
            hVar.d();
            hVar.d();
            hVar.b(1);
            if (hVar.b()) {
                i2 = d != 3 ? 8 : 12;
                i = 0;
                while (i < i2) {
                    if (hVar.b()) {
                        a(hVar, i < 6 ? 16 : 64);
                    }
                    i++;
                }
            }
            i2 = d;
        }
        hVar.d();
        long d2 = (long) hVar.d();
        if (d2 == 0) {
            hVar.d();
        } else if (d2 == 1) {
            hVar.b(1);
            hVar.e();
            hVar.e();
            d2 = (long) hVar.d();
            for (c = 0; ((long) c) < d2; c++) {
                hVar.d();
            }
        }
        hVar.d();
        hVar.b(1);
        d = hVar.d() + 1;
        i = hVar.d() + 1;
        boolean b = hVar.b();
        c = (2 - (b ? 1 : 0)) * i;
        if (!b) {
            hVar.b(1);
        }
        hVar.b(1);
        int i3 = d * 16;
        int i4 = c * 16;
        if (hVar.b()) {
            i = hVar.d();
            int d3 = hVar.d();
            int d4 = hVar.d();
            int d5 = hVar.d();
            if (i2 == 0) {
                c = 1;
                i2 = 2 - (b ? 1 : 0);
            } else {
                c = i2 == 3 ? 1 : 2;
                i2 = (2 - (b ? 1 : 0)) * (i2 == 1 ? 2 : 1);
            }
            i3 -= c * (i + d3);
            i4 -= i2 * (d4 + d5);
        }
        float f2 = 1.0f;
        if (hVar.b() && hVar.b()) {
            c = hVar.c(8);
            if (c == 255) {
                c = hVar.c(16);
                d = hVar.c(16);
                if (!(c == 0 || d == 0)) {
                    f2 = ((float) c) / ((float) d);
                }
                f = f2;
            } else if (c < g.b.length) {
                f = g.b[c];
            } else {
                Log.w("H264Reader", "Unexpected aspect_ratio_idc value: " + c);
            }
            this.a.format(k.a("video/avc", -1, -1, i3, i4, f, arrayList));
            this.b = true;
        }
        f = 1.0f;
        this.a.format(k.a("video/avc", -1, -1, i3, i4, f, arrayList));
        this.b = true;
    }

    private void a(h hVar, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((hVar.e() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (this.e != null) {
            this.e.a(bArr, i, i2);
        }
        if (!this.b) {
            this.f.a(bArr, i, i2);
            this.g.a(bArr, i, i2);
        }
        this.h.a(bArr, i, i2);
    }

    public void a() {
        this.c.a();
        g.a(this.d);
        this.f.a();
        this.g.a();
        this.h.a();
        if (this.e != null) {
            this.e.a();
        }
        this.i = false;
        this.j = 0;
    }

    public void a(i iVar, long j, boolean z) {
        while (iVar.b() > 0) {
            int d = iVar.d();
            int c = iVar.c();
            byte[] bArr = iVar.a;
            this.j += (long) iVar.b();
            this.a.sampleData(iVar, iVar.b());
            while (d < c) {
                int a = g.a(bArr, d, c, this.d);
                if (a < c) {
                    int i = a - d;
                    if (i > 0) {
                        a(bArr, d, a);
                    }
                    int b = g.b(bArr, a);
                    int i2 = c - a;
                    switch (b) {
                        case 5:
                            this.k = true;
                            break;
                        case 9:
                            if (this.i) {
                                if (this.e != null && this.e.b()) {
                                    d = this.e.c();
                                    boolean z2 = this.k;
                                    d = (d == 2 || d == 7) ? 1 : 0;
                                    this.k = d | z2;
                                    this.e.a();
                                }
                                if (this.k && !this.b && this.f.b() && this.g.b()) {
                                    a(this.f, this.g);
                                }
                                this.a.sampleMetadata(this.m, this.k ? 1 : 0, ((int) (this.j - this.l)) - i2, i2, null);
                            }
                            this.i = true;
                            this.l = this.j - ((long) i2);
                            this.m = j;
                            this.k = false;
                            break;
                    }
                    a(j, i < 0 ? -i : 0);
                    a(b);
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
