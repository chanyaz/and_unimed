package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.util.b;
import java.util.Arrays;

final class j {
    public byte[] a;
    public int b;
    private final int c;
    private boolean d;
    private boolean e;

    public j(int i, int i2) {
        this.c = i;
        this.a = new byte[(i2 + 3)];
        this.a[2] = (byte) 1;
    }

    public void a() {
        this.d = false;
        this.e = false;
    }

    public void a(int i) {
        boolean z = true;
        b.b(!this.d);
        if (i != this.c) {
            z = false;
        }
        this.d = z;
        if (this.d) {
            this.b = 3;
            this.e = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            if (this.a.length < this.b + i3) {
                this.a = Arrays.copyOf(this.a, (this.b + i3) * 2);
            }
            System.arraycopy(bArr, i, this.a, this.b, i3);
            this.b = i3 + this.b;
        }
    }

    public boolean b() {
        return this.e;
    }

    public boolean b(int i) {
        if (!this.d) {
            return false;
        }
        this.b -= i;
        this.d = false;
        this.e = true;
        return true;
    }
}
