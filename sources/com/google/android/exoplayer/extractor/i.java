package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.m;
import com.google.android.exoplayer.util.b;

final class i {
    private int a = 1000;
    private long[] b = new long[this.a];
    private int[] c = new int[this.a];
    private int[] d = new int[this.a];
    private long[] e = new long[this.a];
    private byte[][] f = new byte[this.a][];
    private int g;
    private int h;
    private int i;
    private int j;

    public long a(int i) {
        int b = b() - i;
        boolean z = b >= 0 && b <= this.g;
        b.a(z);
        if (b != 0) {
            this.g -= b;
            this.j = ((this.j + this.a) - b) % this.a;
            return this.b[this.j];
        } else if (this.h == 0) {
            return 0;
        } else {
            int i2 = (this.j == 0 ? this.a : this.j) - 1;
            return ((long) this.c[i2]) + this.b[i2];
        }
    }

    public synchronized long a(long j) {
        long j2 = -1;
        synchronized (this) {
            if (this.g != 0 && j >= this.e[this.i]) {
                if (j <= this.e[(this.j == 0 ? this.a : this.j) - 1]) {
                    int i = 0;
                    int i2 = this.i;
                    int i3 = -1;
                    while (i2 != this.j && this.e[i2] <= j) {
                        if ((this.d[i2] & 1) != 0) {
                            i3 = i;
                        }
                        i2 = (i2 + 1) % this.a;
                        i++;
                    }
                    if (i3 != -1) {
                        this.g -= i3;
                        this.i = (this.i + i3) % this.a;
                        this.h += i3;
                        j2 = this.b[this.i];
                    }
                }
            }
        }
        return j2;
    }

    public void a() {
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.g = 0;
    }

    public synchronized void a(long j, int i, long j2, int i2, byte[] bArr) {
        this.e[this.j] = j;
        this.b[this.j] = j2;
        this.c[this.j] = i2;
        this.d[this.j] = i;
        this.f[this.j] = bArr;
        this.g++;
        if (this.g == this.a) {
            int i3 = this.a + 1000;
            Object obj = new long[i3];
            Object obj2 = new long[i3];
            Object obj3 = new int[i3];
            Object obj4 = new int[i3];
            Object obj5 = new byte[i3][];
            int i4 = this.a - this.i;
            System.arraycopy(this.b, this.i, obj, 0, i4);
            System.arraycopy(this.e, this.i, obj2, 0, i4);
            System.arraycopy(this.d, this.i, obj3, 0, i4);
            System.arraycopy(this.c, this.i, obj4, 0, i4);
            System.arraycopy(this.f, this.i, obj5, 0, i4);
            int i5 = this.i;
            System.arraycopy(this.b, 0, obj, i4, i5);
            System.arraycopy(this.e, 0, obj2, i4, i5);
            System.arraycopy(this.d, 0, obj3, i4, i5);
            System.arraycopy(this.c, 0, obj4, i4, i5);
            System.arraycopy(this.f, 0, obj5, i4, i5);
            this.b = obj;
            this.e = obj2;
            this.d = obj3;
            this.c = obj4;
            this.f = obj5;
            this.i = 0;
            this.j = this.a;
            this.g = this.a;
            this.a = i3;
        } else {
            this.j++;
            if (this.j == this.a) {
                this.j = 0;
            }
        }
    }

    public synchronized boolean a(m mVar, j jVar) {
        boolean z;
        if (this.g == 0) {
            z = false;
        } else {
            mVar.e = this.e[this.i];
            mVar.c = this.c[this.i];
            mVar.d = this.d[this.i];
            jVar.a = this.b[this.i];
            jVar.b = this.f[this.i];
            z = true;
        }
        return z;
    }

    public int b() {
        return this.h + this.g;
    }

    public int c() {
        return this.h;
    }

    public synchronized long d() {
        long j;
        this.g--;
        int i = this.i;
        this.i = i + 1;
        this.h++;
        if (this.i == this.a) {
            this.i = 0;
        }
        if (this.g > 0) {
            j = this.b[this.i];
        } else {
            j = this.b[i] + ((long) this.c[i]);
        }
        return j;
    }
}
