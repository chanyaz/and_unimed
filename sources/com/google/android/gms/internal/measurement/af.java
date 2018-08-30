package com.google.android.gms.internal.measurement;

public abstract class af extends ae {
    private boolean a;

    protected af(ah ahVar) {
        super(ahVar);
    }

    protected abstract void a();

    public final boolean x() {
        return this.a;
    }

    protected final void y() {
        if (!x()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void z() {
        a();
        this.a = true;
    }
}
