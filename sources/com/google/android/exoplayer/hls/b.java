package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.e;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import java.util.Arrays;

class b extends e {
    public final String a;
    public final int g;
    private byte[] h;

    public b(DataSource dataSource, c cVar, byte[] bArr, String str, int i) {
        super(dataSource, cVar, 3, 0, null, bArr);
        this.a = str;
        this.g = i;
    }

    protected void a(byte[] bArr, int i) {
        this.h = Arrays.copyOf(bArr, i);
    }

    public byte[] b() {
        return this.h;
    }
}
