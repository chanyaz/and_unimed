package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.DataSource;
import java.io.EOFException;
import java.util.Arrays;

public final class b implements ExtractorInput {
    private static final byte[] a = new byte[4096];
    private final DataSource b;
    private final long c;
    private long d;
    private byte[] e = new byte[8192];
    private int f;
    private int g;

    public b(DataSource dataSource, long j, long j2) {
        this.b = dataSource;
        this.d = j;
        this.c = j2;
    }

    private void a(int i) {
        int i2 = this.f + i;
        if (i2 > this.e.length) {
            this.e = Arrays.copyOf(this.e, Math.max(this.e.length * 2, i2));
        }
    }

    private void b(int i) {
        this.g -= i;
        this.f = 0;
        System.arraycopy(this.e, i, this.e, 0, this.g);
    }

    public void advancePeekPosition(int i) {
        a(i);
        int min = i - Math.min(this.g - this.f, i);
        int i2 = this.g;
        int i3 = min;
        while (i3 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int read = this.b.read(this.e, i2, i3);
            if (read == -1) {
                throw new EOFException();
            }
            i3 -= read;
            i2 += read;
        }
        this.f += i;
        this.g += min;
    }

    public long getLength() {
        return this.c;
    }

    public long getPosition() {
        return this.d;
    }

    public void peekFully(byte[] bArr, int i, int i2) {
        a(i2);
        int min = Math.min(this.g - this.f, i2);
        System.arraycopy(this.e, this.f, bArr, i, min);
        int i3 = i + min;
        int i4 = i2 - min;
        min = this.g;
        int i5 = i3;
        i3 = i4;
        while (i3 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int read = this.b.read(this.e, min, i3);
            if (read == -1) {
                throw new EOFException();
            }
            System.arraycopy(this.e, min, bArr, i5, read);
            i3 -= read;
            min += read;
            i5 += read;
        }
        this.f += i2;
        this.g += i4;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int min = Math.min(this.g, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        int i4 = i + min;
        int i5 = i2 - min;
        if (i5 != 0) {
            i3 = this.b.read(bArr, i4, i5);
        }
        if (i3 == -1) {
            return -1;
        }
        b(min);
        int i6 = i3 + min;
        this.d += (long) i6;
        return i6;
    }

    public void readFully(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2, false);
    }

    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        int min = Math.min(this.g, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        int i3 = i + min;
        int i4 = i2 - min;
        while (i4 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int read = this.b.read(bArr, i3, i4);
            if (read != -1) {
                i3 += read;
                i4 -= read;
            } else if (z && i4 == i2) {
                return false;
            } else {
                throw new EOFException();
            }
        }
        b(min);
        this.d += (long) i2;
        return true;
    }

    public void resetPeekPosition() {
        this.f = 0;
    }

    public void skipFully(int i) {
        int min = Math.min(this.g, i);
        int i2 = i - min;
        while (i2 > 0) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int read = this.b.read(a, 0, Math.min(a.length, i2));
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
        }
        b(min);
        this.d += (long) i;
    }
}
