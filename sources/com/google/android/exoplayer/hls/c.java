package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.e;
import com.google.android.exoplayer.upstream.DataSource;
import java.io.ByteArrayInputStream;

class c extends e {
    public final int a;
    private final j g;
    private final String h;
    private f i;

    public c(DataSource dataSource, com.google.android.exoplayer.upstream.c cVar, byte[] bArr, j jVar, int i, String str) {
        super(dataSource, cVar, 4, 0, null, bArr);
        this.a = i;
        this.g = jVar;
        this.h = str;
    }

    protected void a(byte[] bArr, int i) {
        this.i = (f) this.g.parse(this.h, new ByteArrayInputStream(bArr, 0, i));
    }

    public f b() {
        return this.i;
    }
}
