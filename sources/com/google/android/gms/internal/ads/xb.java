package com.google.android.gms.internal.ads;

final class xb extends xe {
    private final int c;
    private final int d;

    xb(byte[] bArr, int i, int i2) {
        super(bArr);
        zzbah.b(i, i + i2, bArr.length);
        this.c = i;
        this.d = i2;
    }

    public final byte a(int i) {
        int a = a();
        if (((a - (i + 1)) | i) >= 0) {
            return this.b[this.c + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + a);
    }

    public final int a() {
        return this.d;
    }

    protected final void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, g(), bArr, 0, i3);
    }

    protected final int g() {
        return this.c;
    }
}
