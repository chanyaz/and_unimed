package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class gd implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ fq b;

    gd(fq fqVar, AtomicReference atomicReference) {
        this.b = fqVar;
        this.a = atomicReference;
    }

    public final void run() {
        synchronized (this.a) {
            try {
                AtomicReference atomicReference = this.a;
                fn o = this.b.o();
                atomicReference.set(Integer.valueOf(o.b(o.f().s(), dg.L)));
                this.a.notify();
            } catch (Throwable th) {
                this.a.notify();
            }
        }
    }
}
