package com.google.android.exoplayer.extractor;

public interface ExtractorInput {
    void advancePeekPosition(int i);

    long getLength();

    long getPosition();

    void peekFully(byte[] bArr, int i, int i2);

    int read(byte[] bArr, int i, int i2);

    void readFully(byte[] bArr, int i, int i2);

    boolean readFully(byte[] bArr, int i, int i2, boolean z);

    void resetPeekPosition();

    void skipFully(int i);
}
