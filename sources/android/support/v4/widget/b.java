package android.support.v4.widget;

import android.view.animation.AnimationUtils;

class b {
    private int a;
    private int b;
    private float c;
    private float d;
    private long e = Long.MIN_VALUE;
    private long f = 0;
    private int g = 0;
    private int h = 0;
    private long i = -1;
    private float j;
    private int k;

    b() {
    }

    private float a(float f) {
        return ((-4.0f * f) * f) + (4.0f * f);
    }

    private float a(long j) {
        if (j < this.e) {
            return 0.0f;
        }
        if (this.i < 0 || j < this.i) {
            return a.a(((float) (j - this.e)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
        }
        long j2 = j - this.i;
        return (a.a(((float) j2) / ((float) this.k), 0.0f, 1.0f) * this.j) + (1.0f - this.j);
    }

    public void a() {
        this.e = AnimationUtils.currentAnimationTimeMillis();
        this.i = -1;
        this.f = this.e;
        this.j = 0.5f;
        this.g = 0;
        this.h = 0;
    }

    public void a(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public void a(int i) {
        this.a = i;
    }

    public void b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.k = a.a((int) (currentAnimationTimeMillis - this.e), 0, this.b);
        this.j = a(currentAnimationTimeMillis);
        this.i = currentAnimationTimeMillis;
    }

    public void b(int i) {
        this.b = i;
    }

    public boolean c() {
        return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
    }

    public void d() {
        if (this.f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float a = a(a(currentAnimationTimeMillis));
        long j = currentAnimationTimeMillis - this.f;
        this.f = currentAnimationTimeMillis;
        this.g = (int) ((((float) j) * a) * this.c);
        this.h = (int) ((((float) j) * a) * this.d);
    }

    public int e() {
        return (int) (this.c / Math.abs(this.c));
    }

    public int f() {
        return (int) (this.d / Math.abs(this.d));
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }
}
