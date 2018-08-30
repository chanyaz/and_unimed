package com.google.android.exoplayer.util;

public final class i {
    public byte[] a;
    private int b;
    private int c;

    public i(int i) {
        this.a = new byte[i];
        this.c = this.a.length;
    }

    public i(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public i(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }

    public void a() {
        this.b = 0;
        this.c = 0;
    }

    public void a(int i) {
        boolean z = i >= 0 && i <= this.a.length;
        b.a(z);
        this.c = i;
    }

    public void a(h hVar, int i) {
        a(hVar.a, 0, i);
        hVar.a(0);
    }

    public void a(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public int b() {
        return this.c - this.b;
    }

    public void b(int i) {
        boolean z = i >= 0 && i <= this.c;
        b.a(z);
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        b(this.b + i);
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.a == null ? 0 : this.a.length;
    }

    public int f() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public int g() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public int h() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.a;
        i3 = this.b;
        this.b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public long i() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public int j() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.a;
        i3 = this.b;
        this.b = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.a;
        i3 = this.b;
        this.b = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public long k() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public int l() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        i2 |= bArr2[i3] & 255;
        this.b += 2;
        return i2;
    }

    public int m() {
        int j = j();
        if (j >= 0) {
            return j;
        }
        throw new IllegalStateException("Top bit not zero: " + j);
    }

    public long n() {
        long k = k();
        if (k >= 0) {
            return k;
        }
        throw new IllegalStateException("Top bit not zero: " + k);
    }
}
