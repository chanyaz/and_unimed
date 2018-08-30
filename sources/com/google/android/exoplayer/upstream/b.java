package com.google.android.exoplayer.upstream;

import java.io.InputStream;

public final class b extends InputStream {
    private final DataSource a;
    private final c b;
    private final byte[] c;
    private boolean d = false;
    private boolean e = false;

    public b(DataSource dataSource, c cVar) {
        this.a = dataSource;
        this.b = cVar;
        this.c = new byte[1];
    }

    private void b() {
        if (!this.d) {
            this.a.open(this.b);
            this.d = true;
        }
    }

    public void a() {
        b();
    }

    public void close() {
        if (!this.e) {
            this.a.close();
            this.e = true;
        }
    }

    public int read() {
        return read(this.c) == -1 ? -1 : this.c[0] & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        com.google.android.exoplayer.util.b.b(!this.e);
        b();
        return this.a.read(bArr, i, i2);
    }

    public long skip(long j) {
        com.google.android.exoplayer.util.b.b(!this.e);
        b();
        return super.skip(j);
    }
}
