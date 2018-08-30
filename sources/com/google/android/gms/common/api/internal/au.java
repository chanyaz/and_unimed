package com.google.android.gms.common.api.internal;

abstract class au {
    private final zzbc a;

    protected au(zzbc zzbc) {
        this.a = zzbc;
    }

    protected abstract void a();

    public final void a(at atVar) {
        atVar.f.lock();
        try {
            if (atVar.n == this.a) {
                a();
                atVar.f.unlock();
            }
        } finally {
            atVar.f.unlock();
        }
    }
}
