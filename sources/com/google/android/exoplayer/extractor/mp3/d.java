package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.f;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;

final class d implements Seeker {
    private final long[] a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;

    private d(long[] jArr, long j, long j2, long j3, long j4) {
        this.a = jArr;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
    }

    private long a(int i) {
        return (this.d * ((long) (i + 1))) / 100;
    }

    public static d a(f fVar, i iVar, long j, long j2) {
        int i = fVar.g;
        int i2 = fVar.d;
        long j3 = j + ((long) fVar.c);
        if ((iVar.j() & 7) != 7) {
            return null;
        }
        int m = iVar.m();
        if (m == 0) {
            return null;
        }
        long a = m.a((long) m, ((long) i) * 1000000, (long) i2);
        long m2 = (long) iVar.m();
        iVar.c(1);
        long[] jArr = new long[99];
        for (m = 0; m < 99; m++) {
            jArr[m] = (long) iVar.f();
        }
        return new d(jArr, j3, m2, a, j2);
    }

    public long getDurationUs() {
        return this.d;
    }

    public long getPosition(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        float f3 = (((float) j) * 100.0f) / ((float) this.d);
        if (f3 <= 0.0f) {
            f = 0.0f;
        } else if (f3 < 100.0f) {
            int i = (int) f3;
            if (i != 0) {
                f2 = (float) this.a[i - 1];
            }
            if (i < 99) {
                f = (float) this.a[i];
            }
            f = ((f - f2) * (f3 - ((float) i))) + f2;
        }
        long j2 = ((long) ((f * 0.00390625f) * ((float) this.c))) + this.b;
        return this.e != -1 ? Math.min(j2, this.e - 1) : j2;
    }

    public long getTimeUs(long j) {
        long j2 = (256 * (j - this.b)) / this.c;
        int a = m.a(this.a, j2, true, false);
        long a2 = a(a);
        if (a == 98) {
            return a2;
        }
        long j3 = a == -1 ? 0 : this.a[a];
        return (((j2 - j3) * (a(a + 1) - a2)) / (this.a[a + 1] - j3)) + a2;
    }

    public boolean isSeekable() {
        return true;
    }
}
