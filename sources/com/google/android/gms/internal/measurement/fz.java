package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class fz implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ fq e;

    fz(fq fqVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.e = fqVar;
        this.a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void run() {
        this.e.q.o().a(this.a, this.b, this.c, this.d);
    }
}
