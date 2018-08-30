package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;

public final class pt extends ByteArrayOutputStream {
    private final hj a;

    public pt(hj hjVar, int i) {
        this.a = hjVar;
        this.buf = this.a.a(Math.max(i, 256));
    }

    private final void a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.a.a((this.count + i) << 1);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.a.a(this.buf);
            this.buf = a;
        }
    }

    public final void close() {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}
