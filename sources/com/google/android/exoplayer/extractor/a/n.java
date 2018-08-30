package com.google.android.exoplayer.extractor.a;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.i;

final class n {
    public int a;
    public int b;
    public int[] c;
    public int[] d;
    public long[] e;
    public boolean[] f;
    public boolean g;
    public boolean[] h;
    public int i;
    public i j;
    public boolean k;

    n() {
    }

    public void a() {
        this.b = 0;
        this.g = false;
        this.k = false;
    }

    public void a(int i) {
        this.b = i;
        if (this.c == null || this.c.length < this.b) {
            int i2 = (i * 125) / 100;
            this.c = new int[i2];
            this.d = new int[i2];
            this.e = new long[i2];
            this.f = new boolean[i2];
            this.h = new boolean[i2];
        }
    }

    public void a(ExtractorInput extractorInput) {
        extractorInput.readFully(this.j.a, 0, this.i);
        this.j.b(0);
        this.k = false;
    }

    public void a(i iVar) {
        iVar.a(this.j.a, 0, this.i);
        this.j.b(0);
        this.k = false;
    }

    public void b(int i) {
        if (this.j == null || this.j.c() < i) {
            this.j = new i(i);
        }
        this.i = i;
        this.g = true;
        this.k = true;
    }

    public long c(int i) {
        return this.e[i] + ((long) this.d[i]);
    }
}
