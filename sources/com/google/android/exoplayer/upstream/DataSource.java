package com.google.android.exoplayer.upstream;

public interface DataSource {
    void close();

    long open(c cVar);

    int read(byte[] bArr, int i, int i2);
}
