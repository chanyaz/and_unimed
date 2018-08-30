package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.f;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;

final class c implements Seeker {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;

    private c(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    public static c a(f fVar, i iVar, long j) {
        iVar.c(10);
        int j2 = iVar.j();
        if (j2 <= 0) {
            return null;
        }
        int i = fVar.d;
        long a = m.a((long) j2, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, (long) i);
        int g = iVar.g();
        int g2 = iVar.g();
        int g3 = iVar.g();
        long[] jArr = new long[g];
        long[] jArr2 = new long[g];
        long j3 = a / ((long) g);
        long j4 = 0;
        for (int i2 = 0; i2 < g; i2++) {
            switch (g3) {
                case 1:
                    j2 = iVar.f();
                    break;
                case 2:
                    j2 = iVar.g();
                    break;
                case 3:
                    j2 = iVar.h();
                    break;
                case 4:
                    j2 = iVar.m();
                    break;
                default:
                    return null;
            }
            j4 += j3;
            jArr[i2] = j4;
            j += (long) (j2 * g2);
            jArr2[i2] = j;
        }
        return new c(jArr, jArr2, ((long) fVar.c) + j, a);
    }

    public long getDurationUs() {
        return this.d;
    }

    public long getPosition(long j) {
        int a = m.a(this.a, j, false, false);
        return (a == -1 ? 0 : this.b[a]) + this.c;
    }

    public long getTimeUs(long j) {
        return this.a[m.a(this.b, j, true, true)];
    }

    public boolean isSeekable() {
        return true;
    }
}
