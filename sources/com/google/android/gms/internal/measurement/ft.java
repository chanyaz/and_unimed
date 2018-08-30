package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class ft implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ fq c;

    ft(fq fqVar, AtomicReference atomicReference, boolean z) {
        this.c = fqVar;
        this.a = atomicReference;
        this.b = z;
    }

    public final void run() {
        this.c.h().a(this.a, this.b);
    }
}
