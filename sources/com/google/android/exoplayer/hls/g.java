package com.google.android.exoplayer.hls;

public final class g implements Comparable<Long> {
    public final boolean a;
    public final double b;
    public final String c;
    public final long d;
    public final boolean e;
    public final String f;
    public final String g;
    public final int h;
    public final int i;

    public g(String str, double d, boolean z, long j, boolean z2, String str2, String str3, int i, int i2) {
        this.c = str;
        this.b = d;
        this.a = z;
        this.d = j;
        this.e = z2;
        this.f = str2;
        this.g = str3;
        this.h = i;
        this.i = i2;
    }

    /* renamed from: a */
    public int compareTo(Long l) {
        return this.d > l.longValue() ? 1 : this.d < l.longValue() ? -1 : 0;
    }
}
