package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.extractor.c;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.upstream.DataSource;

public abstract class a extends i {
    public final boolean a;
    private c k;
    private int l;

    public a(DataSource dataSource, com.google.android.exoplayer.upstream.c cVar, int i, f fVar, long j, long j2, int i2, boolean z, boolean z2) {
        super(dataSource, cVar, i, fVar, j, j2, i2, z);
        this.a = z2;
    }

    public final int a() {
        return this.l;
    }

    public void a(c cVar) {
        this.k = cVar;
        this.l = cVar.b();
    }

    public abstract k b();

    public abstract com.google.android.exoplayer.drm.a c();

    protected final c d() {
        return this.k;
    }
}
