package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

final class d {
    private static final int[] a = new int[]{128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public long a(ExtractorInput extractorInput, boolean z, boolean z2) {
        int i;
        if (this.c == 0) {
            if (!extractorInput.readFully(this.b, 0, 1, z)) {
                return -1;
            }
            int i2 = this.b[0] & 255;
            this.d = -1;
            for (i = 0; i < a.length; i++) {
                if ((a[i] & i2) != 0) {
                    this.d = i + 1;
                    break;
                }
            }
            if (this.d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        extractorInput.readFully(this.b, 1, this.d - 1);
        if (z2) {
            byte[] bArr = this.b;
            bArr[0] = (byte) (bArr[0] & (a[this.d - 1] ^ -1));
        }
        long j = 0;
        for (i = 0; i < this.d; i++) {
            j = (j << 8) | ((long) (this.b[i] & 255));
        }
        this.c = 0;
        return j;
    }

    public void a() {
        this.c = 0;
        this.d = 0;
    }

    public int b() {
        return this.d;
    }
}
