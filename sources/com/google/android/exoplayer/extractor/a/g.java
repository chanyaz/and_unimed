package com.google.android.exoplayer.extractor.a;

import com.appnext.base.b.c;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.extractor.a;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public final class g implements Extractor {
    private static final byte[] a = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private final int b;
    private final i c;
    private final i d;
    private final i e;
    private final i f;
    private final byte[] g;
    private final Stack<b> h;
    private final n i;
    private int j;
    private int k;
    private long l;
    private int m;
    private i n;
    private int o;
    private int p;
    private int q;
    private int r;
    private l s;
    private f t;
    private ExtractorOutput u;
    private TrackOutput v;
    private boolean w;

    public g() {
        this(0);
    }

    public g(int i) {
        this.b = i;
        this.f = new i(16);
        this.c = new i(com.google.android.exoplayer.util.g.a);
        this.d = new i(4);
        this.e = new i(1);
        this.g = new byte[16];
        this.h = new Stack();
        this.i = new n();
        a();
    }

    private static f a(f fVar, i iVar) {
        iVar.b(8);
        int b = a.b(iVar.j());
        iVar.c(4);
        if ((b & 1) != 0) {
            iVar.c(8);
        }
        return new f((b & 2) != 0 ? iVar.m() - 1 : fVar.a, (b & 8) != 0 ? iVar.m() : fVar.b, (b & 16) != 0 ? iVar.m() : fVar.c, (b & 32) != 0 ? iVar.m() : fVar.d);
    }

    private static f a(i iVar) {
        iVar.b(16);
        return new f(iVar.m() - 1, iVar.m(), iVar.m(), iVar.j());
    }

    private static a a(i iVar, long j) {
        long i;
        long i2;
        iVar.b(8);
        int a = a.a(iVar.j());
        iVar.c(4);
        long i3 = iVar.i();
        if (a == 0) {
            i = iVar.i() + j;
            i2 = iVar.i();
        } else {
            i = iVar.n() + j;
            i2 = iVar.n();
        }
        iVar.c(2);
        int g = iVar.g();
        int[] iArr = new int[g];
        long[] jArr = new long[g];
        long[] jArr2 = new long[g];
        long[] jArr3 = new long[g];
        long a2 = m.a(i2, 1000000, i3);
        int i4 = 0;
        long j2 = i;
        while (true) {
            int i5 = i4;
            long j3 = i2;
            i2 = a2;
            if (i5 >= g) {
                return new a(iArr, jArr, jArr2, jArr3);
            }
            int j4 = iVar.j();
            if ((Integer.MIN_VALUE & j4) != 0) {
                throw new IllegalStateException("Unhandled indirect reference");
            }
            a2 = iVar.i();
            iArr[i5] = j4 & MoPubClientPositioning.NO_REPEAT;
            jArr[i5] = j2;
            jArr3[i5] = i2;
            i2 = j3 + a2;
            a2 = m.a(i2, 1000000, i3);
            jArr2[i5] = a2 - jArr3[i5];
            iVar.c(4);
            j2 += (long) iArr[i5];
            i4 = i5 + 1;
        }
    }

    private void a() {
        this.j = 0;
        this.m = 0;
    }

    private void a(b bVar) {
        if (bVar.ag == a.s) {
            b(bVar);
        } else if (bVar.ag == a.B) {
            c(bVar);
        } else if (!this.h.isEmpty()) {
            ((b) this.h.peek()).a(bVar);
        }
    }

    private void a(c cVar, long j) {
        if (!this.h.isEmpty()) {
            ((b) this.h.peek()).a(cVar);
        } else if (cVar.ag == a.r) {
            this.u.seekMap(a(cVar.ah, j));
            this.w = true;
        }
    }

    private static void a(l lVar, f fVar, long j, int i, i iVar, n nVar) {
        iVar.b(8);
        int b = a.b(iVar.j());
        int m = iVar.m();
        if ((b & 1) != 0) {
            iVar.c(4);
        }
        Object obj = (b & 4) != 0 ? 1 : null;
        int i2 = fVar.d;
        if (obj != null) {
            i2 = iVar.m();
        }
        Object obj2 = (b & 256) != 0 ? 1 : null;
        Object obj3 = (b & 512) != 0 ? 1 : null;
        Object obj4 = (b & c.jk) != 0 ? 1 : null;
        Object obj5 = (b & 2048) != 0 ? 1 : null;
        nVar.a(m);
        int[] iArr = nVar.c;
        int[] iArr2 = nVar.d;
        long[] jArr = nVar.e;
        boolean[] zArr = nVar.f;
        long j2 = lVar.g;
        Object obj6 = (lVar.f == l.a && (i & 1) == 1) ? 1 : null;
        int i3 = 0;
        while (i3 < m) {
            int m2 = obj2 != null ? iVar.m() : fVar.b;
            int m3 = obj3 != null ? iVar.m() : fVar.c;
            int j3 = (i3 != 0 || obj == null) ? obj4 != null ? iVar.j() : fVar.d : i2;
            if (obj5 != null) {
                iArr2[i3] = (int) (((long) (iVar.j() * 1000)) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr[i3] = (1000 * j) / j2;
            iArr[i3] = m3;
            boolean z = ((j3 >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            j += (long) m2;
            i3++;
        }
    }

    private static void a(l lVar, f fVar, b bVar, n nVar, int i, byte[] bArr) {
        b(lVar, fVar, bVar.e(a.C), nVar, i, bArr);
    }

    private static void a(m mVar, i iVar, n nVar) {
        boolean z = true;
        int i = mVar.b;
        iVar.b(8);
        if ((a.b(iVar.j()) & 1) == 1) {
            iVar.c(8);
        }
        int f = iVar.f();
        int m = iVar.m();
        if (m != nVar.b) {
            throw new IllegalStateException("Length mismatch: " + m + ", " + nVar.b);
        }
        if (f == 0) {
            boolean[] zArr = nVar.h;
            int i2 = 0;
            f = 0;
            while (i2 < m) {
                int f2 = iVar.f();
                int i3 = f + f2;
                zArr[i2] = f2 > i;
                i2++;
                f = i3;
            }
        } else {
            if (f <= i) {
                z = false;
            }
            f = (f * m) + 0;
            Arrays.fill(nVar.h, 0, m, z);
        }
        nVar.b(f);
    }

    private static void a(i iVar, int i, n nVar) {
        iVar.b(i + 8);
        int b = a.b(iVar.j());
        if ((b & 1) != 0) {
            throw new IllegalStateException("Overriding TrackEncryptionBox parameters is unsupported");
        }
        boolean z = (b & 2) != 0;
        int m = iVar.m();
        if (m != nVar.b) {
            throw new IllegalStateException("Length mismatch: " + m + ", " + nVar.b);
        }
        Arrays.fill(nVar.h, 0, m, z);
        nVar.b(iVar.b());
        nVar.a(iVar);
    }

    private static void a(i iVar, n nVar) {
        a(iVar, 0, nVar);
    }

    private static void a(i iVar, n nVar, byte[] bArr) {
        iVar.b(8);
        iVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, a)) {
            a(iVar, 16, nVar);
        }
    }

    private static boolean a(int i) {
        return i == a.b || i == a.c || i == a.A || i == a.G || i == a.h || i == a.F || i == a.B || i == a.s || i == a.i || i == a.t || i == a.r || i == a.H || i == a.n || i == a.o || i == a.E || i == a.C || i == a.u || i == a.p || i == a.q || i == a.D || i == a.v || i == a.w || i == a.x || i == a.I || i == a.Q || i == a.R || i == a.S || i == a.T || i == a.f;
    }

    private boolean a(ExtractorInput extractorInput) {
        boolean z = false;
        if (this.m == 0) {
            if (!extractorInput.readFully(this.f.a, 0, 8, true)) {
                return false;
            }
            this.m = 8;
            this.f.b(0);
            this.l = this.f.i();
            this.k = this.f.j();
        }
        if (this.l == 1) {
            extractorInput.readFully(this.f.a, 8, 8);
            this.m += 8;
            this.l = this.f.n();
        }
        if (this.k == a.h) {
            if (!this.w) {
                this.u.seekMap(SeekMap.f);
                this.w = true;
            }
            if (this.i.k) {
                this.j = 2;
                return true;
            }
            this.j = 3;
            return true;
        } else if (!a(this.k)) {
            if (this.l <= 2147483647L) {
                z = true;
            }
            b.b(z);
            this.n = null;
            this.j = 1;
            return true;
        } else if (b(this.k)) {
            this.h.add(new b(this.k, (extractorInput.getPosition() + this.l) - 8));
            a();
            return true;
        } else {
            b.b(this.m == 8);
            b.b(this.l <= 2147483647L);
            this.n = new i((int) this.l);
            System.arraycopy(this.f.a, 0, this.n.a, 0, 8);
            this.j = 1;
            return true;
        }
    }

    private static long b(i iVar) {
        iVar.b(8);
        return a.a(iVar.j()) == 1 ? iVar.n() : iVar.i();
    }

    private void b(ExtractorInput extractorInput) {
        int i = ((int) this.l) - this.m;
        if (this.n != null) {
            extractorInput.readFully(this.n.a, 8, i);
            a(new c(this.k, this.n), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i);
        }
        long position = extractorInput.getPosition();
        while (!this.h.isEmpty() && ((b) this.h.peek()).ah == position) {
            a((b) this.h.pop());
        }
        a();
    }

    private void b(b bVar) {
        List list = bVar.ai;
        int size = list.size();
        com.google.android.exoplayer.drm.a aVar = null;
        for (int i = 0; i < size; i++) {
            c cVar = (c) list.get(i);
            if (cVar.ag == a.I) {
                if (aVar == null) {
                    aVar = new com.google.android.exoplayer.drm.b("video/mp4");
                }
                byte[] bArr = cVar.ah.a;
                aVar.a(j.a(bArr), bArr);
            }
        }
        if (aVar != null) {
            this.u.drmInitData(aVar);
        }
        this.t = a(bVar.e(a.D).d(a.p).ah);
        this.s = d.a(bVar.e(a.u), bVar.d(a.t));
        b.b(this.s != null);
        this.v.format(this.s.i);
    }

    private static void b(l lVar, f fVar, b bVar, n nVar, int i, byte[] bArr) {
        long b = bVar.d(a.n) == null ? 0 : b(bVar.d(a.n).ah);
        f a = a(fVar, bVar.d(a.o).ah);
        nVar.a = a.a;
        a(lVar, a, b, i, bVar.d(a.q).ah, nVar);
        c d = bVar.d(a.Q);
        if (d != null) {
            a(lVar.j[a.a], d.ah, nVar);
        }
        d = bVar.d(a.S);
        if (d != null) {
            a(d.ah, nVar);
        }
        int size = bVar.ai.size();
        for (int i2 = 0; i2 < size; i2++) {
            d = (c) bVar.ai.get(i2);
            if (d.ag == a.R) {
                a(d.ah, nVar, bArr);
            }
        }
    }

    private static boolean b(int i) {
        return i == a.s || i == a.u || i == a.v || i == a.w || i == a.x || i == a.y || i == a.B || i == a.C || i == a.D;
    }

    private int c(i iVar) {
        int i = this.s.j[this.i.a].b;
        boolean z = this.i.h[this.o];
        this.e.a[0] = (byte) ((z ? 128 : 0) | i);
        this.e.b(0);
        this.v.sampleData(this.e, 1);
        this.v.sampleData(iVar, i);
        if (!z) {
            return i + 1;
        }
        int g = iVar.g();
        iVar.c(-2);
        g = (g * 6) + 2;
        this.v.sampleData(iVar, g);
        return g + (i + 1);
    }

    private void c(ExtractorInput extractorInput) {
        this.i.a(extractorInput);
        this.j = 3;
    }

    private void c(b bVar) {
        this.i.a();
        a(this.s, this.t, bVar, this.i, this.b, this.g);
        this.o = 0;
    }

    private boolean d(ExtractorInput extractorInput) {
        int i = 2;
        if (this.o >= this.i.b) {
            a();
            return false;
        }
        if (this.j == 3) {
            this.p = this.i.c[this.o];
            if (this.i.g) {
                this.q = c(this.i.j);
                this.p += this.q;
            } else {
                this.q = 0;
            }
            this.r = 0;
            this.j = 4;
        }
        if (this.s.k != -1) {
            byte[] bArr = this.d.a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            int i2 = this.s.k;
            int i3 = 4 - this.s.k;
            while (this.q < this.p) {
                if (this.r == 0) {
                    extractorInput.readFully(this.d.a, i3, i2);
                    this.d.b(0);
                    this.r = this.d.m();
                    this.c.b(0);
                    this.v.sampleData(this.c, 4);
                    this.q += 4;
                    this.p += i3;
                } else {
                    int sampleData = this.v.sampleData(extractorInput, this.r, false);
                    this.q += sampleData;
                    this.r -= sampleData;
                }
            }
        } else {
            while (this.q < this.p) {
                this.q = this.v.sampleData(extractorInput, this.p - this.q, false) + this.q;
            }
        }
        long c = this.i.c(this.o) * 1000;
        if (!this.i.g) {
            i = 0;
        }
        this.v.sampleMetadata(c, i | (this.i.f[this.o] ? 1 : 0), this.p, 0, this.i.g ? this.s.j[this.i.a].c : null);
        this.o++;
        this.j = 3;
        return true;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.u = extractorOutput;
        this.v = extractorOutput.track(0);
        this.u.endTracks();
    }

    public int read(ExtractorInput extractorInput, com.google.android.exoplayer.extractor.g gVar) {
        while (true) {
            switch (this.j) {
                case 0:
                    if (a(extractorInput)) {
                        break;
                    }
                    return -1;
                case 1:
                    b(extractorInput);
                    break;
                case 2:
                    c(extractorInput);
                    break;
                default:
                    if (!d(extractorInput)) {
                        break;
                    }
                    return 0;
            }
        }
    }

    public void seek() {
        this.h.clear();
        a();
    }

    public boolean sniff(ExtractorInput extractorInput) {
        return k.a(extractorInput);
    }
}
