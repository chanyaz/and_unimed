package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.c;

public abstract class b implements Loadable {
    public final int b;
    public final int c;
    public final f d;
    public final c e;
    protected final DataSource f;

    public b(DataSource dataSource, c cVar, int i, int i2, f fVar) {
        this.f = (DataSource) com.google.android.exoplayer.util.b.a((Object) dataSource);
        this.e = (c) com.google.android.exoplayer.util.b.a((Object) cVar);
        this.b = i;
        this.c = i2;
        this.d = fVar;
    }

    public abstract long e();
}
