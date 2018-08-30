package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.util.h;
import java.util.Arrays;

final class f {
    private final h a = new h(this.b);
    private byte[] b = new byte[128];
    private int c;
    private boolean d;
    private int e;

    public f() {
        a();
    }

    public void a() {
        this.d = false;
        this.c = 0;
        this.e = -1;
    }

    public void a(int i) {
        if (i == 1) {
            a();
            this.d = true;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            if (this.b.length < this.c + i3) {
                this.b = Arrays.copyOf(this.b, (this.c + i3) * 2);
            }
            System.arraycopy(bArr, i, this.b, this.c, i3);
            this.c = i3 + this.c;
            this.a.a(this.b, this.c);
            i3 = this.a.c();
            if (i3 != -1 && i3 <= this.a.a()) {
                this.a.b(i3);
                i3 = this.a.c();
                if (i3 != -1 && i3 <= this.a.a()) {
                    this.e = this.a.d();
                    this.d = false;
                }
            }
        }
    }

    public boolean b() {
        return this.e != -1;
    }

    public int c() {
        return this.e;
    }
}
