package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.extractor.g;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.f;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;
import java.io.EOFException;

public final class Mp3Extractor implements Extractor {
    private static final int a = m.c("ID3");
    private static final int b = m.c("Xing");
    private static final int c = m.c("Info");
    private static final int d = m.c("VBRI");
    private final a e = new a(12288);
    private final i f = new i(4);
    private final f g = new f();
    private ExtractorOutput h;
    private TrackOutput i;
    private int j;
    private Seeker k;
    private long l;
    private int m;
    private int n;

    interface Seeker extends SeekMap {
        long getDurationUs();

        long getTimeUs(long j);
    }

    private int a(ExtractorInput extractorInput) {
        if (this.n == 0) {
            if (b(extractorInput) == -1) {
                return -1;
            }
            if (this.l == -1) {
                this.l = this.k.getTimeUs(a(extractorInput, this.e));
            }
            this.n = this.g.c;
        }
        long j = this.l + ((((long) this.m) * 1000000) / ((long) this.g.d));
        this.n -= this.e.a(this.i, this.n);
        if (this.n > 0) {
            this.e.b();
            int sampleData = this.i.sampleData(extractorInput, this.n, true);
            if (sampleData == -1) {
                return -1;
            }
            this.n -= sampleData;
            if (this.n > 0) {
                return 0;
            }
        }
        this.i.sampleMetadata(j, 1, this.g.c, 0, null);
        this.m += this.g.g;
        this.n = 0;
        return 0;
    }

    private static long a(ExtractorInput extractorInput, a aVar) {
        return extractorInput.getPosition() - ((long) aVar.d());
    }

    private void a(ExtractorInput extractorInput, long j) {
        long j2;
        if (a(extractorInput, j, extractorInput.getLength())) {
            this.e.b();
            if (this.k == null) {
                this.e.a(extractorInput, this.f.a, 0, 4);
                this.f.b(0);
                j2 = j + ((long) this.g.c);
                f.a(this.f.j(), this.g);
            } else {
                return;
            }
        }
        j2 = j;
        this.e.c();
        this.k = new b(j2, this.g.f * 1000, extractorInput.getLength());
    }

    private boolean a(ExtractorInput extractorInput, long j, long j2) {
        int i = 17;
        this.e.b();
        this.k = null;
        i a = this.e.a(extractorInput, this.g.c);
        if ((this.g.a & 1) == 1) {
            if (this.g.e != 1) {
                i = 32;
            }
        } else if (this.g.e == 1) {
            i = 9;
        }
        a.b(i + 4);
        i = a.j();
        if (i == b || i == c) {
            this.k = d.a(this.g, a, j, j2);
            return true;
        }
        a.b(36);
        if (a.j() != d) {
            return false;
        }
        this.k = c.a(this.g, a, j);
        return true;
    }

    private long b(ExtractorInput extractorInput) {
        this.e.b();
        if (!this.e.b(extractorInput, this.f.a, 0, 4)) {
            return -1;
        }
        this.e.c();
        this.f.b(0);
        int j = this.f.j();
        if ((j & -128000) != (this.j & -128000) || f.a(j) == -1) {
            this.j = 0;
            this.e.b(extractorInput, 1);
            return c(extractorInput);
        }
        f.a(j, this.g);
        return 0;
    }

    private long c(ExtractorInput extractorInput) {
        try {
            return d(extractorInput);
        } catch (EOFException e) {
            return -1;
        }
    }

    private long d(ExtractorInput extractorInput) {
        if (extractorInput.getPosition() == 0) {
            this.e.a();
        } else {
            this.e.c();
        }
        long a = a(extractorInput, this.e);
        if (a == 0) {
            this.e.a(extractorInput, this.f.a, 0, 3);
            this.f.b(0);
            if (this.f.h() == a) {
                extractorInput.skipFully(3);
                extractorInput.readFully(this.f.a, 0, 4);
                extractorInput.skipFully(((((this.f.a[0] & 127) << 21) | ((this.f.a[1] & 127) << 14)) | ((this.f.a[2] & 127) << 7)) | (this.f.a[3] & 127));
                this.e.a();
                a = a(extractorInput, this.e);
            } else {
                this.e.c();
            }
        }
        this.e.b();
        int i = 0;
        int i2 = 0;
        long j = a;
        while (j - a < 131072) {
            if (!this.e.b(extractorInput, this.f.a, 0, 4)) {
                return -1;
            }
            this.f.b(0);
            int j2 = this.f.j();
            if (i == 0 || (-128000 & j2) == (-128000 & i)) {
                int a2 = f.a(j2);
                if (a2 != -1) {
                    if (i2 == 0) {
                        f.a(j2, this.g);
                    } else {
                        j2 = i;
                    }
                    i = i2 + 1;
                    if (i == 4) {
                        this.e.c();
                        this.j = j2;
                        if (this.k == null) {
                            a(extractorInput, j);
                            this.h.seekMap(this.k);
                            this.i.format(k.b(this.g.b, 4096, this.k.getDurationUs(), this.g.e, this.g.d, null));
                        }
                        return j;
                    }
                    this.e.b(extractorInput, a2 - 4);
                    i2 = i;
                    i = j2;
                }
            }
            i = 0;
            this.e.c();
            this.e.b(extractorInput, 1);
            this.e.b();
            j++;
            i2 = 0;
        }
        throw new ParserException("Searched too many bytes while resynchronizing.");
    }

    public void init(ExtractorOutput extractorOutput) {
        this.h = extractorOutput;
        this.i = extractorOutput.track(0);
        extractorOutput.endTracks();
    }

    public int read(ExtractorInput extractorInput, g gVar) {
        return (this.j == 0 && c(extractorInput) == -1) ? -1 : a(extractorInput);
    }

    public void seek() {
        this.j = 0;
        this.m = 0;
        this.l = -1;
        this.n = 0;
        this.e.a();
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int i;
        i iVar = new i(4);
        extractorInput.peekFully(iVar.a, 0, 3);
        if (iVar.h() == a) {
            extractorInput.advancePeekPosition(3);
            extractorInput.peekFully(iVar.a, 0, 4);
            i = ((((iVar.a[0] & 127) << 21) | ((iVar.a[1] & 127) << 14)) | ((iVar.a[2] & 127) << 7)) | (iVar.a[3] & 127);
            extractorInput.advancePeekPosition(i);
            i += 10;
        } else {
            extractorInput.resetPeekPosition();
            i = 0;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i4 - i < 4096) {
            extractorInput.peekFully(iVar.a, 0, 4);
            iVar.b(0);
            int j = iVar.j();
            if (i2 == 0 || (j & -128000) == (i2 & -128000)) {
                int a = f.a(j);
                if (a != -1) {
                    if (i3 != 0) {
                        j = i2;
                    }
                    i2 = i3 + 1;
                    if (i2 == 4) {
                        return true;
                    }
                    extractorInput.advancePeekPosition(a - 4);
                    i3 = i2;
                    i2 = j;
                }
            }
            extractorInput.resetPeekPosition();
            j = i4 + 1;
            extractorInput.advancePeekPosition(j);
            i2 = 0;
            i3 = 0;
            i4 = j;
        }
        return false;
    }
}
