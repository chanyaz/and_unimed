package com.google.android.gms.internal.ads;

public final class vy {
    private final byte[] a;

    private vy(byte[] bArr, int i, int i2) {
        this.a = new byte[i2];
        System.arraycopy(bArr, 0, this.a, 0, i2);
    }

    public static vy a(byte[] bArr) {
        return bArr == null ? null : new vy(bArr, 0, bArr.length);
    }

    public final byte[] a() {
        Object obj = new byte[this.a.length];
        System.arraycopy(this.a, 0, obj, 0, this.a.length);
        return obj;
    }
}
