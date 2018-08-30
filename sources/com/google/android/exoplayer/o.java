package com.google.android.exoplayer;

public final class o {
    public final int a;
    private final long b;
    private final long c;

    public o(int i, long j, long j2) {
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    public long[] a(long[] jArr) {
        if (jArr == null || jArr.length < 2) {
            jArr = new long[2];
        }
        jArr[0] = this.b;
        jArr[1] = this.c;
        return jArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return oVar.a == this.a && oVar.b == this.b && oVar.c == this.c;
    }

    public int hashCode() {
        return (int) (((long) (0 | (this.a << 30))) | (((this.b + this.c) / 1000) & 1073741823));
    }
}
