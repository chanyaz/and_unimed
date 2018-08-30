package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.InputStream;

final class lb extends FilterInputStream {
    private final long a;
    private long b;

    lb(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    final long a() {
        return this.a - this.b;
    }

    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.b++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.b += (long) read;
        }
        return read;
    }
}
