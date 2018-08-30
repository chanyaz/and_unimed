package com.google.android.exoplayer.hls;

import java.util.List;

public final class f extends i {
    public final int a;
    public final int b;
    public final int c;
    public final List<g> d;
    public final boolean e;
    public final long f;

    public f(String str, int i, int i2, int i3, boolean z, List<g> list) {
        super(str, 1);
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = z;
        this.d = list;
        if (list.isEmpty()) {
            this.f = 0;
            return;
        }
        g gVar = (g) list.get(list.size() - 1);
        this.f = ((long) (gVar.b * 1000000.0d)) + gVar.d;
    }
}
