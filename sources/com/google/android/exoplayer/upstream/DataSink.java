package com.google.android.exoplayer.upstream;

public interface DataSink {
    void close();

    DataSink open(c cVar);

    void write(byte[] bArr, int i, int i2);
}
