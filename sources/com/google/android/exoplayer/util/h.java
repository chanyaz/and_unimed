package com.google.android.exoplayer.util;

public final class h {
    public byte[] a;
    private int b;
    private int c;
    private int d;

    public h(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public h(byte[] bArr, int i) {
        this.a = bArr;
        this.d = i;
    }

    private int f() {
        int i = 0;
        int i2 = 0;
        while (!b()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = c(i2);
        }
        return i3 + i;
    }

    private void g() {
        boolean z = this.b >= 0 && this.c >= 0 && this.c < 8 && (this.b < this.d || (this.b == this.d && this.c == 0));
        b.b(z);
    }

    public int a() {
        return ((this.d - this.b) * 8) - this.c;
    }

    public void a(int i) {
        this.b = i / 8;
        this.c = i - (this.b * 8);
        g();
    }

    public void a(byte[] bArr, int i) {
        this.a = bArr;
        this.b = 0;
        this.c = 0;
        this.d = i;
    }

    public void b(int i) {
        this.b += i / 8;
        this.c += i % 8;
        if (this.c > 7) {
            this.b++;
            this.c -= 8;
        }
        g();
    }

    public boolean b() {
        return c(1) == 1;
    }

    public int c() {
        Object obj = null;
        int i = this.b;
        int i2 = this.c;
        int i3 = 0;
        while (this.b < this.d && !b()) {
            i3++;
        }
        if (this.b == this.d) {
            obj = 1;
        }
        this.b = i;
        this.c = i2;
        return obj != null ? -1 : (i3 * 2) + 1;
    }

    public int c(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3 = 0;
            while (i >= 8) {
                i -= 8;
                i3 |= ((this.c != 0 ? ((this.a[this.b] & 255) << this.c) | ((this.a[this.b + 1] & 255) >>> (8 - this.c)) : this.a[this.b]) & 255) << i;
                this.b++;
            }
            if (i > 0) {
                int i4 = this.c + i;
                byte b = (byte) (255 >> (8 - i));
                if (i4 > 8) {
                    i2 = (b & (((this.a[this.b] & 255) << (i4 - 8)) | ((this.a[this.b + 1] & 255) >> (16 - i4)))) | i3;
                    this.b++;
                } else {
                    i2 = (b & ((this.a[this.b] & 255) >> (8 - i4))) | i3;
                    if (i4 == 8) {
                        this.b++;
                    }
                }
                this.c = i4 % 8;
            } else {
                i2 = i3;
            }
            g();
        }
        return i2;
    }

    public int d() {
        return f();
    }

    public int e() {
        int f = f();
        return (f % 2 == 0 ? -1 : 1) * ((f + 1) / 2);
    }
}
