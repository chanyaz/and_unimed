package com.google.android.gms.internal.measurement;

abstract class hv extends hu {
    private boolean b;

    hv(hw hwVar) {
        super(hwVar);
        this.a.a(this);
    }

    final boolean I() {
        return this.b;
    }

    protected final void J() {
        if (!I()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void K() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        p();
        this.a.E();
        this.b = true;
    }

    protected abstract boolean p();
}
