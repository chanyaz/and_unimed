package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.i;

final class c {
    private final i a = new i(8);
    private int b;

    private long b(ExtractorInput extractorInput) {
        int i = 0;
        extractorInput.peekFully(this.a.a, 0, 1);
        int i2 = this.a.a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i4++;
            i3 >>= 1;
        }
        i3 = (i3 ^ -1) & i2;
        extractorInput.peekFully(this.a.a, 1, i4);
        while (i < i4) {
            i3 = (i3 << 8) + (this.a.a[i + 1] & 255);
            i++;
        }
        this.b += i4 + 1;
        return (long) i3;
    }

    public boolean a(ExtractorInput extractorInput) {
        long length = extractorInput.getLength();
        long j = (length == -1 || length > 1024) ? 1024 : length;
        int i = (int) j;
        extractorInput.peekFully(this.a.a, 0, 4);
        j = this.a.i();
        this.b = 4;
        while (j != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.peekFully(this.a.a, 0, 1);
            j = ((j << 8) & -256) | ((long) (this.a.a[0] & 255));
        }
        j = b(extractorInput);
        long j2 = (long) this.b;
        if (j == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + j >= length) {
            return false;
        }
        while (((long) this.b) < j2 + j) {
            if (b(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            length = b(extractorInput);
            if (length < 0 || length > 2147483647L) {
                return false;
            }
            if (length != 0) {
                extractorInput.advancePeekPosition((int) length);
                this.b = (int) (length + ((long) this.b));
            }
        }
        return ((long) this.b) == j + j2;
    }
}
