package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.i;
import java.io.EOFException;
import java.nio.BufferOverflowException;

final class a {
    private final i a;
    private final int b;
    private int c;
    private int d;
    private int e;

    public a(int i) {
        this.b = i;
        this.a = new i(i * 2);
    }

    private boolean c(ExtractorInput extractorInput, int i) {
        if ((this.c + i) - this.e > this.b) {
            throw new BufferOverflowException();
        }
        int i2 = i - (this.d - this.c);
        if (i2 <= 0) {
            return true;
        }
        if (!extractorInput.readFully(this.a.a, this.d, i2, true)) {
            return false;
        }
        this.d = i2 + this.d;
        return true;
    }

    private boolean c(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        if (!c(extractorInput, i2)) {
            return false;
        }
        if (bArr != null) {
            System.arraycopy(this.a.a, this.c, bArr, i, i2);
        }
        this.c += i2;
        return true;
    }

    public int a(TrackOutput trackOutput, int i) {
        if (i == 0) {
            return 0;
        }
        this.a.b(this.c);
        int min = Math.min(this.d - this.c, i);
        trackOutput.sampleData(this.a, min);
        this.c += min;
        return min;
    }

    public i a(ExtractorInput extractorInput, int i) {
        if (c(extractorInput, i)) {
            i iVar = new i(this.a.a, this.d);
            iVar.b(this.c);
            this.c += i;
            return iVar;
        }
        throw new EOFException();
    }

    public void a() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public void a(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        if (!c(extractorInput, bArr, i, i2)) {
            throw new EOFException();
        }
    }

    public void b() {
        if (this.c > this.b) {
            System.arraycopy(this.a.a, this.c, this.a.a, 0, this.d - this.c);
            this.d -= this.c;
            this.c = 0;
        }
        this.e = this.c;
    }

    public void b(ExtractorInput extractorInput, int i) {
        if (!c(extractorInput, null, 0, i)) {
            throw new EOFException();
        }
    }

    public boolean b(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        return c(extractorInput, bArr, i, i2);
    }

    public void c() {
        this.c = this.e;
    }

    public int d() {
        return this.d - this.c;
    }
}
