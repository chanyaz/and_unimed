package com.google.android.gms.internal.measurement;

abstract class fo extends fn {
    private boolean a;

    fo(es esVar) {
        super(esVar);
        this.q.a(this);
    }

    final boolean A() {
        return this.a;
    }

    protected final void B() {
        if (!A()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void C() {
        if (this.a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!p()) {
            this.q.w();
            this.a = true;
        }
    }

    public final void D() {
        if (this.a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        c_();
        this.q.w();
        this.a = true;
    }

    protected void c_() {
    }

    protected abstract boolean p();
}
