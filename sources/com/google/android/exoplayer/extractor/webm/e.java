package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.drm.c;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.extractor.a;
import com.google.android.exoplayer.util.d;
import com.google.android.exoplayer.util.g;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class e implements Extractor {
    private boolean A;
    private int B;
    private long C;
    private int D;
    private int E;
    private int[] F;
    private int G;
    private int H;
    private int I;
    private byte[] J;
    private int K;
    private boolean L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private ExtractorOutput Q;
    private final EbmlReader a;
    private final d b;
    private final i c;
    private final i d;
    private final i e;
    private final i f;
    private final i g;
    private final i h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private g n;
    private g o;
    private g p;
    private boolean q;
    private int r;
    private long s;
    private boolean t;
    private long u;
    private long v;
    private int w;
    private long x;
    private d y;
    private d z;

    public e() {
        this(new a());
    }

    e(EbmlReader ebmlReader) {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.x = -1;
        this.a = ebmlReader;
        this.a.init(new f(this, null));
        this.b = new d();
        this.e = new i(4);
        this.f = new i(ByteBuffer.allocate(4).putInt(-1).array());
        this.g = new i(4);
        this.c = new i(g.a);
        this.d = new i(4);
        this.h = new i();
    }

    private int a(ExtractorInput extractorInput, TrackOutput trackOutput, int i) {
        int b = this.h.b();
        if (b > 0) {
            b = Math.min(i, b);
            trackOutput.sampleData(this.h, b);
        } else {
            b = trackOutput.sampleData(extractorInput, i, false);
        }
        this.K += b;
        this.N += b;
        return b;
    }

    private long a(long j) {
        if (this.k == -1) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return m.a(j, this.k, 1000);
    }

    private void a() {
        this.K = 0;
        this.N = 0;
        this.M = 0;
        this.L = false;
        this.h.a();
    }

    private void a(ExtractorInput extractorInput, int i) {
        if (this.e.c() < i) {
            if (this.e.e() < i) {
                this.e.a(Arrays.copyOf(this.e.a, Math.max(this.e.a.length * 2, i)), this.e.c());
            }
            extractorInput.readFully(this.e.a, this.e.c(), i - this.e.c());
            this.e.a(i);
        }
    }

    private void a(ExtractorInput extractorInput, TrackOutput trackOutput, g gVar, int i) {
        if (!this.L) {
            if (gVar.e) {
                this.I &= -3;
                extractorInput.readFully(this.e.a, 0, 1);
                this.K++;
                if ((this.e.a[0] & 128) == 128) {
                    throw new ParserException("Extension bit is set in signal byte");
                } else if ((this.e.a[0] & 1) == 1) {
                    this.e.a[0] = (byte) 8;
                    this.e.b(0);
                    trackOutput.sampleData(this.e, 1);
                    this.N++;
                    this.I |= 2;
                }
            } else if (gVar.f != null) {
                this.h.a(gVar.f, gVar.f.length);
            }
            this.L = true;
        }
        int c = this.h.c() + i;
        if ("V_MPEG4/ISO/AVC".equals(gVar.a) || "V_MPEGH/ISO/HEVC".equals(gVar.a)) {
            byte[] bArr = this.d.a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            int i2 = gVar.k;
            int i3 = 4 - gVar.k;
            while (this.K < c) {
                if (this.M == 0) {
                    a(extractorInput, bArr, i3, i2);
                    this.d.b(0);
                    this.M = this.d.m();
                    this.c.b(0);
                    trackOutput.sampleData(this.c, 4);
                    this.N += 4;
                } else {
                    this.M -= a(extractorInput, trackOutput, this.M);
                }
            }
        } else {
            while (this.K < c) {
                a(extractorInput, trackOutput, c - this.K);
            }
        }
        if ("A_VORBIS".equals(gVar.a)) {
            this.f.b(0);
            trackOutput.sampleData(this.f, 4);
            this.N += 4;
        }
    }

    private void a(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.h.b());
        extractorInput.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.h.a(bArr, i, min);
        }
        this.K += i2;
    }

    private void a(TrackOutput trackOutput, long j) {
        trackOutput.sampleMetadata(j, this.I, this.N, 0, this.J);
        this.O = true;
        a();
    }

    private boolean a(com.google.android.exoplayer.extractor.g gVar, long j) {
        if (this.t) {
            this.v = j;
            gVar.a = this.u;
            this.w = 1;
            this.t = false;
            return true;
        } else if (this.w != 2 || this.v == -1) {
            return false;
        } else {
            gVar.a = this.v;
            this.v = -1;
            return true;
        }
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str);
    }

    private static int[] a(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }

    private SeekMap b() {
        int i = 0;
        if (this.i == -1 || this.m == -1 || this.y == null || this.y.a() == 0 || this.z == null || this.z.a() != this.y.a()) {
            this.y = null;
            this.z = null;
            return SeekMap.f;
        }
        int a = this.y.a();
        int[] iArr = new int[a];
        long[] jArr = new long[a];
        long[] jArr2 = new long[a];
        long[] jArr3 = new long[a];
        for (int i2 = 0; i2 < a; i2++) {
            jArr3[i2] = this.y.a(i2);
            jArr[i2] = this.i + this.z.a(i2);
        }
        while (i < a - 1) {
            iArr[i] = (int) (jArr[i + 1] - jArr[i]);
            jArr2[i] = jArr3[i + 1] - jArr3[i];
            i++;
        }
        iArr[a - 1] = (int) ((this.i + this.j) - jArr[a - 1]);
        jArr2[a - 1] = this.m - jArr3[a - 1];
        this.y = null;
        this.z = null;
        return new a(iArr, jArr, jArr2, jArr3);
    }

    int a(int i) {
        switch (i) {
            case 131:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 22186:
            case 22203:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 25152:
            case 28032:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
                return 4;
            case 181:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    void a(int i, double d) {
        switch (i) {
            case 181:
                this.n.m = (int) d;
                return;
            case 17545:
                this.l = (long) d;
                return;
            default:
                return;
        }
    }

    void a(int i, int i2, ExtractorInput extractorInput) {
        switch (i) {
            case 161:
            case 163:
                if (this.B == 0) {
                    this.G = (int) this.b.a(extractorInput, false, true);
                    this.H = this.b.b();
                    this.B = 1;
                    this.e.a();
                }
                if ((this.o == null || this.p == null || this.o.b == this.G || this.p.b == this.G) && ((this.o == null || this.p != null || this.o.b == this.G) && (this.o != null || this.p == null || this.p.b == this.G))) {
                    g gVar = (this.o == null || this.G != this.o.b) ? this.p : this.o;
                    TrackOutput trackOutput = gVar.p;
                    if (this.B == 1) {
                        a(extractorInput, 3);
                        int i3 = (this.e.a[2] & 6) >> 1;
                        if (i3 == 0) {
                            this.E = 1;
                            this.F = a(this.F, 1);
                            this.F[0] = (i2 - this.H) - 3;
                        } else if (i != 163) {
                            throw new ParserException("Lacing only supported in SimpleBlocks.");
                        } else {
                            a(extractorInput, 4);
                            this.E = (this.e.a[3] & 255) + 1;
                            this.F = a(this.F, this.E);
                            int i4;
                            int i5;
                            int i6;
                            int[] iArr;
                            if (i3 == 2) {
                                Arrays.fill(this.F, 0, this.E, ((i2 - this.H) - 4) / this.E);
                            } else if (i3 == 1) {
                                i4 = 0;
                                i5 = 4;
                                for (i3 = 0; i3 < this.E - 1; i3++) {
                                    this.F[i3] = 0;
                                    do {
                                        i5++;
                                        a(extractorInput, i5);
                                        i6 = this.e.a[i5 - 1] & 255;
                                        iArr = this.F;
                                        iArr[i3] = iArr[i3] + i6;
                                    } while (i6 == 255);
                                    i4 += this.F[i3];
                                }
                                this.F[this.E - 1] = ((i2 - this.H) - i5) - i4;
                            } else if (i3 == 3) {
                                i4 = 0;
                                i5 = 4;
                                for (i3 = 0; i3 < this.E - 1; i3++) {
                                    this.F[i3] = 0;
                                    i5++;
                                    a(extractorInput, i5);
                                    if (this.e.a[i5 - 1] == (byte) 0) {
                                        throw new ParserException("No valid varint length mask found");
                                    }
                                    long j = 0;
                                    int i7 = 0;
                                    while (true) {
                                        int i8 = i7;
                                        if (i8 < 8) {
                                            i7 = 1 << (7 - i8);
                                            if ((this.e.a[i5 - 1] & i7) != 0) {
                                                int i9 = i5 - 1;
                                                i5 += i8;
                                                a(extractorInput, i5);
                                                j = (long) ((this.e.a[i9] & 255) & (i7 ^ -1));
                                                for (i7 = i9 + 1; i7 < i5; i7++) {
                                                    j = ((long) (this.e.a[i7] & 255)) | (j << 8);
                                                }
                                                if (i3 > 0) {
                                                    j -= (1 << ((i8 * 7) + 6)) - 1;
                                                }
                                            } else {
                                                i7 = i8 + 1;
                                            }
                                        }
                                    }
                                    if (j < -2147483648L || j > 2147483647L) {
                                        throw new ParserException("EBML lacing sample size out of range.");
                                    }
                                    i6 = (int) j;
                                    iArr = this.F;
                                    if (i3 != 0) {
                                        i6 += this.F[i3 - 1];
                                    }
                                    iArr[i3] = i6;
                                    i4 += this.F[i3];
                                }
                                this.F[this.E - 1] = ((i2 - this.H) - i5) - i4;
                            } else {
                                throw new IllegalStateException("Unexpected lacing value: " + i3);
                            }
                        }
                        this.C = this.x + a((long) ((this.e.a[0] << 8) | (this.e.a[1] & 255)));
                        Object obj = (this.e.a[2] & 8) == 8 ? 1 : null;
                        Object obj2 = (i == 163 && (this.e.a[2] & 128) == 128) ? 1 : null;
                        this.I = (obj != null ? 134217728 : 0) | (obj2 != null ? 1 : 0);
                        this.J = gVar.g;
                        this.B = 2;
                        this.D = 0;
                    }
                    if (i == 163) {
                        while (this.D < this.E) {
                            a(extractorInput, trackOutput, gVar, this.F[this.D]);
                            a(trackOutput, this.C + ((long) ((this.D * gVar.d) / 1000)));
                            this.D++;
                        }
                        this.B = 0;
                        return;
                    }
                    a(extractorInput, trackOutput, gVar, this.F[0]);
                    return;
                }
                extractorInput.skipFully(i2 - this.H);
                this.B = 0;
                return;
            case 16981:
                this.n.f = new byte[i2];
                extractorInput.readFully(this.n.f, 0, i2);
                return;
            case 18402:
                this.n.g = new byte[i2];
                extractorInput.readFully(this.n.g, 0, i2);
                return;
            case 21419:
                Arrays.fill(this.g.a, (byte) 0);
                extractorInput.readFully(this.g.a, 4 - i2, i2);
                this.g.b(0);
                this.r = (int) this.g.i();
                return;
            case 25506:
                this.n.h = new byte[i2];
                extractorInput.readFully(this.n.h, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    void a(int i, long j) {
        switch (i) {
            case 131:
                this.n.c = (int) j;
                return;
            case 159:
                this.n.l = (int) j;
                return;
            case 176:
                this.n.i = (int) j;
                return;
            case 179:
                this.y.a(a(j));
                return;
            case 186:
                this.n.j = (int) j;
                return;
            case 215:
                this.n.b = (int) j;
                return;
            case 231:
                this.x = a(j);
                return;
            case 241:
                if (!this.A) {
                    this.z.a(j);
                    this.A = true;
                    return;
                }
                return;
            case 251:
                this.P = true;
                return;
            case 16980:
                if (j != 3) {
                    throw new ParserException("ContentCompAlgo " + j + " not supported");
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw new ParserException("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j != 1) {
                    throw new ParserException("EBMLReadVersion " + j + " not supported");
                }
                return;
            case 18401:
                if (j != 5) {
                    throw new ParserException("ContentEncAlgo " + j + " not supported");
                }
                return;
            case 18408:
                if (j != 1) {
                    throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case 20529:
                if (j != 0) {
                    throw new ParserException("ContentEncodingOrder " + j + " not supported");
                }
                return;
            case 20530:
                if (j != 1) {
                    throw new ParserException("ContentEncodingScope " + j + " not supported");
                }
                return;
            case 21420:
                this.s = this.i + j;
                return;
            case 22186:
                this.n.n = j;
                return;
            case 22203:
                this.n.o = j;
                return;
            case 2352003:
                this.n.d = (int) j;
                return;
            case 2807729:
                this.k = j;
                return;
            default:
                return;
        }
    }

    void a(int i, long j, long j2) {
        switch (i) {
            case 160:
                this.P = false;
                return;
            case 174:
                this.n = new g();
                return;
            case 187:
                this.A = false;
                return;
            case 19899:
                this.r = -1;
                this.s = -1;
                return;
            case 20533:
                this.n.e = true;
                return;
            case 408125543:
                if (this.i == -1 || this.i == j) {
                    this.i = j;
                    this.j = j2;
                    return;
                }
                throw new ParserException("Multiple Segment elements not supported");
            case 475249515:
                this.y = new d();
                this.z = new d();
                return;
            case 524531317:
                if (this.w != 0) {
                    return;
                }
                if (this.u != -1) {
                    this.t = true;
                    return;
                }
                this.Q.seekMap(SeekMap.f);
                this.w = 2;
                return;
            default:
                return;
        }
    }

    void a(int i, String str) {
        switch (i) {
            case 134:
                this.n.a = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            default:
                return;
        }
    }

    void b(int i) {
        switch (i) {
            case 160:
                if (this.B == 2) {
                    if (!this.P) {
                        this.I |= 1;
                    }
                    TrackOutput trackOutput = (this.o == null || this.G != this.o.b) ? this.p.p : this.o.p;
                    a(trackOutput, this.C);
                    this.B = 0;
                    return;
                }
                return;
            case 174:
                if (this.n.b == -1 || this.n.c == -1) {
                    throw new ParserException("Mandatory element TrackNumber or TrackType not found");
                } else if ((this.n.c != 2 || this.o == null) && (this.n.c != 1 || this.p == null)) {
                    if (this.n.c == 2 && a(this.n.a)) {
                        this.o = this.n;
                        this.o.p = this.Q.track(this.o.b);
                        this.o.p.format(this.o.a(this.m));
                    } else if (this.n.c == 1 && a(this.n.a)) {
                        this.p = this.n;
                        this.p.p = this.Q.track(this.p.b);
                        this.p.p.format(this.p.a(this.m));
                    }
                    this.n = null;
                    return;
                } else {
                    this.n = null;
                    return;
                }
            case 19899:
                if (this.r == -1 || this.s == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                } else if (this.r == 475249515) {
                    this.u = this.s;
                    return;
                } else {
                    return;
                }
            case 25152:
                if (!this.n.e) {
                    return;
                }
                if (this.n.g == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                } else if (!this.q) {
                    this.Q.drmInitData(new c("video/webm", this.n.g));
                    this.q = true;
                    return;
                } else {
                    return;
                }
            case 28032:
                if (this.n.e && this.n.f != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.k == -1) {
                    this.k = 1000000;
                }
                if (this.l != -1) {
                    this.m = a(this.l);
                    return;
                }
                return;
            case 374648427:
                if (this.p == null && this.o == null) {
                    throw new ParserException("No valid tracks were found");
                }
                this.Q.endTracks();
                return;
            case 475249515:
                if (this.w != 2) {
                    this.Q.seekMap(b());
                    this.w = 2;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void init(ExtractorOutput extractorOutput) {
        this.Q = extractorOutput;
    }

    public int read(ExtractorInput extractorInput, com.google.android.exoplayer.extractor.g gVar) {
        this.O = false;
        boolean z = true;
        while (z && !this.O) {
            z = this.a.read(extractorInput);
            if (z && a(gVar, extractorInput.getPosition())) {
                return 1;
            }
        }
        return !z ? -1 : 0;
    }

    public void seek() {
        this.x = -1;
        this.B = 0;
        this.a.reset();
        this.b.a();
        a();
    }

    public boolean sniff(ExtractorInput extractorInput) {
        return new c().a(extractorInput);
    }
}
