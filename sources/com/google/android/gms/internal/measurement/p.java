package com.google.android.gms.internal.measurement;

public abstract class p {
    protected volatile int b = -1;

    protected int a() {
        return 0;
    }

    public abstract p a(h hVar);

    public void a(i iVar) {
    }

    /* renamed from: b */
    public p clone() {
        return (p) super.clone();
    }

    public final int c() {
        if (this.b < 0) {
            d();
        }
        return this.b;
    }

    public final int d() {
        int a = a();
        this.b = a;
        return a;
    }

    public String toString() {
        return q.a(this);
    }
}
