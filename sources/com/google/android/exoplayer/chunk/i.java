package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.b;

public abstract class i extends b {
    public final long g;
    public final long h;
    public final int i;
    public final boolean j;

    public i(DataSource dataSource, c cVar, int i, f fVar, long j, long j2, int i2, boolean z) {
        super(dataSource, cVar, 1, i, fVar);
        b.a((Object) fVar);
        this.g = j;
        this.h = j2;
        this.i = i2;
        this.j = z;
    }
}
