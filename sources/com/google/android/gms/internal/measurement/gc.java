package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class gc implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ fq b;

    gc(fq fqVar, AtomicReference atomicReference) {
        this.b = fqVar;
        this.a = atomicReference;
    }

    public final void run() {
        synchronized (this.a) {
            try {
                AtomicReference atomicReference = this.a;
                fn o = this.b.o();
                atomicReference.set(Long.valueOf(o.a(o.f().s(), dg.K)));
                this.a.notify();
            } catch (Throwable th) {
                this.a.notify();
            }
        }
    }
}
