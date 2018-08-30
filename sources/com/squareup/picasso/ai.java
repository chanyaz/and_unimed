package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

class ai {
    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final Cache b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    ai(Cache cache) {
        this.b = cache;
        this.a.start();
        ao.a(this.a.getLooper());
        this.c = new aj(this.a.getLooper(), this);
    }

    private static long a(int i, long j) {
        return j / ((long) i);
    }

    private void a(Bitmap bitmap, int i) {
        this.c.sendMessage(this.c.obtainMessage(i, ao.a(bitmap), 0));
    }

    void a() {
        this.c.sendEmptyMessage(0);
    }

    void a(long j) {
        this.c.sendMessage(this.c.obtainMessage(4, Long.valueOf(j)));
    }

    void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    void a(Long l) {
        this.l++;
        this.f += l.longValue();
        this.i = a(this.l, this.f);
    }

    void b() {
        this.c.sendEmptyMessage(1);
    }

    void b(long j) {
        this.m++;
        this.g += j;
        this.j = a(this.m, this.g);
    }

    void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    void c() {
        this.d++;
    }

    void c(long j) {
        this.n++;
        this.h += j;
        this.k = a(this.m, this.h);
    }

    void d() {
        this.e++;
    }

    ak e() {
        return new ak(this.b.maxSize(), this.b.size(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }
}
