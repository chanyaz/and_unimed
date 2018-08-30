package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class fv implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ fq b;

    fv(fq fqVar, AtomicReference atomicReference) {
        this.b = fqVar;
        this.a = atomicReference;
    }

    public final void run() {
        this.b.h().a(this.a);
    }
}
