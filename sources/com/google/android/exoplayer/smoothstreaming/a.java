package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.util.m;

public class a {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final b e;
    public final c[] f;
    public final long g;
    public final long h;

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, b bVar, c[] cVarArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = bVar;
        this.f = cVarArr;
        this.h = j3 == 0 ? -1 : m.a(j3, 1000000, j);
        this.g = j2 == 0 ? -1 : m.a(j2, 1000000, j);
    }
}
