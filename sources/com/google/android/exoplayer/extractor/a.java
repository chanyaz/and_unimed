package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.util.m;

public final class a implements SeekMap {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.a = iArr.length;
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
    }

    public int a(long j) {
        return m.a(this.e, j, true, true);
    }

    public long getPosition(long j) {
        return this.c[a(j)];
    }

    public boolean isSeekable() {
        return true;
    }
}
