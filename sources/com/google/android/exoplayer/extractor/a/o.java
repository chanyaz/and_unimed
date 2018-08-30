package com.google.android.exoplayer.extractor.a;

import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.m;

final class o {
    public final int a;
    public final long[] b;
    public final int[] c;
    public final long[] d;
    public final int[] e;

    o(long[] jArr, int[] iArr, long[] jArr2, int[] iArr2) {
        boolean z = true;
        b.a(iArr.length == jArr2.length);
        b.a(jArr.length == jArr2.length);
        if (iArr2.length != jArr2.length) {
            z = false;
        }
        b.a(z);
        this.b = jArr;
        this.c = iArr;
        this.d = jArr2;
        this.e = iArr2;
        this.a = jArr.length;
    }

    public int a(long j) {
        int a = m.a(this.d, j, true, false);
        while (a >= 0) {
            if (this.d[a] <= j && (this.e[a] & 1) != 0) {
                return a;
            }
            a--;
        }
        return -1;
    }

    public int b(long j) {
        int b = m.b(this.d, j, true, false);
        while (b < this.d.length) {
            if (this.d[b] >= j && (this.e[b] & 1) != 0) {
                return b;
            }
            b++;
        }
        return -1;
    }
}
