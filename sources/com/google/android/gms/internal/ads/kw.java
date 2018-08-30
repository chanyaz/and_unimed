package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final /* synthetic */ class kw implements Runnable {
    private final lk a;
    private final zzanz b;
    private final Class c;
    private final zzanj d;
    private final Executor e;

    kw(lk lkVar, zzanz zzanz, Class cls, zzanj zzanj, Executor executor) {
        this.a = lkVar;
        this.b = zzanz;
        this.c = cls;
        this.d = zzanj;
        this.e = executor;
    }

    public final void run() {
        kq.a(this.a, this.b, this.c, this.d, this.e);
    }
}
