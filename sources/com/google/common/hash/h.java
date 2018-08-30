package com.google.common.hash;

import com.google.common.base.s;
import java.io.Serializable;

final class h extends g implements Serializable {
    private static final long serialVersionUID = 0;
    final byte[] a;

    h(byte[] bArr) {
        this.a = (byte[]) s.a((Object) bArr);
    }

    public int a() {
        return this.a.length * 8;
    }

    public int b() {
        s.b(this.a.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(this.a.length));
        return (((this.a[0] & 255) | ((this.a[1] & 255) << 8)) | ((this.a[2] & 255) << 16)) | ((this.a[3] & 255) << 24);
    }

    public long c() {
        s.b(this.a.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", Integer.valueOf(this.a.length));
        return e();
    }

    public byte[] d() {
        return (byte[]) this.a.clone();
    }

    public long e() {
        long j = (long) (this.a[0] & 255);
        for (int i = 1; i < Math.min(this.a.length, 8); i++) {
            j |= (((long) this.a[i]) & 255) << (i * 8);
        }
        return j;
    }
}
