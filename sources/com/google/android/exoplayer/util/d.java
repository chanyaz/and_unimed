package com.google.android.exoplayer.util;

import java.util.Arrays;

public final class d {
    private int a;
    private long[] b;

    public d() {
        this(32);
    }

    public d(int i) {
        this.b = new long[i];
    }

    public int a() {
        return this.a;
    }

    public long a(int i) {
        if (i >= 0 && i < this.a) {
            return this.b[i];
        }
        throw new IndexOutOfBoundsException("Invalid size " + i + ", size is " + this.a);
    }

    public void a(long j) {
        if (this.a == this.b.length) {
            this.b = Arrays.copyOf(this.b, this.a * 2);
        }
        long[] jArr = this.b;
        int i = this.a;
        this.a = i + 1;
        jArr[i] = j;
    }
}
