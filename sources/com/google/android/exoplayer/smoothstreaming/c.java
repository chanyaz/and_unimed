package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.util.m;
import java.util.List;

public class c {
    public final int a;
    public final String b;
    public final long c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final d[] k;
    public final int l;
    private final String m;
    private final String n;
    private final List<Long> o;
    private final long[] p;
    private final long q;

    public c(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, int i6, String str5, d[] dVarArr, List<Long> list, long j2) {
        this.m = str;
        this.n = str2;
        this.a = i;
        this.b = str3;
        this.c = j;
        this.d = str4;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = str5;
        this.k = dVarArr;
        this.l = list.size();
        this.o = list;
        this.q = m.a(j2, 1000000, j);
        this.p = m.a((List) list, 1000000, j);
    }
}
