package com.google.android.exoplayer.extractor.a;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.g;
import com.google.android.exoplayer.util.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class h implements Extractor, SeekMap {
    private final i a = new i(g.a);
    private final i b = new i(4);
    private final i c = new i(16);
    private final Stack<b> d = new Stack();
    private int e;
    private int g;
    private long h;
    private int i;
    private i j;
    private int k;
    private int l;
    private int m;
    private ExtractorOutput n;
    private i[] o;

    public h() {
        a();
    }

    private void a() {
        this.e = 1;
        this.i = 0;
    }

    private void a(b bVar) {
        List arrayList = new ArrayList();
        long j = Long.MAX_VALUE;
        for (int i = 0; i < bVar.aj.size(); i++) {
            b bVar2 = (b) bVar.aj.get(i);
            if (bVar2.ag == a.u) {
                l a = d.a(bVar2, bVar.d(a.t));
                if (a != null) {
                    o a2 = d.a(a, bVar2.e(a.v).e(a.w).e(a.x));
                    if (a2.a != 0) {
                        i iVar = new i(a, a2, this.n.track(i));
                        iVar.c.format(a.i);
                        arrayList.add(iVar);
                        long j2 = a2.b[0];
                        if (j2 < j) {
                            j = j2;
                        }
                    }
                }
            }
        }
        this.o = (i[]) arrayList.toArray(new i[0]);
        this.n.endTracks();
        this.n.seekMap(this);
    }

    private static boolean a(int i) {
        return i == a.F || i == a.t || i == a.G || i == a.V || i == a.W || i == a.H || i == a.b || i == a.y || i == a.i || i == a.A || i == a.Y || i == a.Z || i == a.aa || i == a.ab || i == a.ac || i == a.ad || i == a.ae || i == a.E || i == a.f;
    }

    private boolean a(ExtractorInput extractorInput) {
        if (this.i == 0) {
            if (!extractorInput.readFully(this.c.a, 0, 8, true)) {
                return false;
            }
            this.i = 8;
            this.c.b(0);
            this.h = this.c.i();
            this.g = this.c.j();
        }
        if (this.h == 1) {
            extractorInput.readFully(this.c.a, 8, 8);
            this.i += 8;
            this.h = this.c.n();
        }
        if (b(this.g)) {
            this.d.add(new b(this.g, (extractorInput.getPosition() + this.h) - ((long) this.i)));
            a();
        } else if (a(this.g)) {
            b.b(this.i == 8);
            b.b(this.h <= 2147483647L);
            this.j = new i((int) this.h);
            System.arraycopy(this.c.a, 0, this.j.a, 0, 8);
            this.e = 2;
        } else {
            this.j = null;
            this.e = 2;
        }
        return true;
    }

    private boolean a(ExtractorInput extractorInput, com.google.android.exoplayer.extractor.g gVar) {
        boolean z;
        long j = this.h - ((long) this.i);
        long position = extractorInput.getPosition() + j;
        if (this.j != null) {
            extractorInput.readFully(this.j.a, this.i, (int) j);
            if (this.d.isEmpty()) {
                z = false;
            } else {
                ((b) this.d.peek()).a(new c(this.g, this.j));
                z = false;
            }
        } else if (j < 262144) {
            extractorInput.skipFully((int) j);
            z = false;
        } else {
            gVar.a = j + extractorInput.getPosition();
            z = true;
        }
        while (!this.d.isEmpty() && ((b) this.d.peek()).ah == position) {
            b bVar = (b) this.d.pop();
            if (bVar.ag == a.s) {
                a(bVar);
                this.d.clear();
                this.e = 3;
                return false;
            } else if (!this.d.isEmpty()) {
                ((b) this.d.peek()).a(bVar);
            }
        }
        a();
        return z;
    }

    private int b() {
        int i = -1;
        long j = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.o.length; i2++) {
            i iVar = this.o[i2];
            int i3 = iVar.d;
            if (i3 != iVar.b.a) {
                long j2 = iVar.b.b[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }

    private int b(ExtractorInput extractorInput, com.google.android.exoplayer.extractor.g gVar) {
        int b = b();
        if (b == -1) {
            return -1;
        }
        i iVar = this.o[b];
        TrackOutput trackOutput = iVar.c;
        int i = iVar.d;
        long j = iVar.b.b[i];
        long position = (j - extractorInput.getPosition()) + ((long) this.l);
        if (position < 0 || position >= 262144) {
            gVar.a = j;
            return 1;
        }
        extractorInput.skipFully((int) position);
        this.k = iVar.b.c[i];
        int i2;
        if (iVar.a.k != -1) {
            byte[] bArr = this.b.a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            i2 = iVar.a.k;
            int i3 = 4 - iVar.a.k;
            while (this.l < this.k) {
                if (this.m == 0) {
                    extractorInput.readFully(this.b.a, i3, i2);
                    this.b.b(0);
                    this.m = this.b.m();
                    this.a.b(0);
                    trackOutput.sampleData(this.a, 4);
                    this.l += 4;
                    this.k += i3;
                } else {
                    int sampleData = trackOutput.sampleData(extractorInput, this.m, false);
                    this.l += sampleData;
                    this.m -= sampleData;
                }
            }
        } else {
            while (this.l < this.k) {
                i2 = trackOutput.sampleData(extractorInput, this.k - this.l, false);
                this.l += i2;
                this.m -= i2;
            }
        }
        trackOutput.sampleMetadata(iVar.b.d[i], iVar.b.e[i], this.k, 0, null);
        iVar.d++;
        this.l = 0;
        this.m = 0;
        return 0;
    }

    private static boolean b(int i) {
        return i == a.s || i == a.u || i == a.v || i == a.w || i == a.x;
    }

    public long getPosition(long j) {
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < this.o.length; i++) {
            o oVar = this.o[i].b;
            int a = oVar.a(j);
            if (a == -1) {
                a = oVar.b(j);
            }
            this.o[i].d = a;
            long j3 = oVar.b[this.o[i].d];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.n = extractorOutput;
    }

    public boolean isSeekable() {
        return true;
    }

    public int read(ExtractorInput extractorInput, com.google.android.exoplayer.extractor.g gVar) {
        while (true) {
            switch (this.e) {
                case 0:
                    if (extractorInput.getPosition() != 0) {
                        this.e = 3;
                        break;
                    }
                    a();
                    break;
                case 1:
                    if (a(extractorInput)) {
                        break;
                    }
                    return -1;
                case 2:
                    if (!a(extractorInput, gVar)) {
                        break;
                    }
                    return 1;
                default:
                    return b(extractorInput, gVar);
            }
        }
    }

    public void seek() {
        this.d.clear();
        this.i = 0;
        this.l = 0;
        this.m = 0;
        this.e = 0;
    }

    public boolean sniff(ExtractorInput extractorInput) {
        return k.b(extractorInput);
    }
}
