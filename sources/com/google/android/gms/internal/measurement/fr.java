package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class fr implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ fq b;

    fr(fq fqVar, AtomicReference atomicReference) {
        this.b = fqVar;
        this.a = atomicReference;
    }

    public final void run() {
        synchronized (this.a) {
            try {
                this.a.set(Boolean.valueOf(this.b.o().v()));
                this.a.notify();
            } catch (Throwable th) {
                this.a.notify();
            }
        }
    }
}
