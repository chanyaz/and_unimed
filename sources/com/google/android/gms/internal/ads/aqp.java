package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class aqp implements Runnable {
    private final lk a;
    private final Future b;

    aqp(lk lkVar, Future future) {
        this.a = lkVar;
        this.b = future;
    }

    public final void run() {
        lk lkVar = this.a;
        Future future = this.b;
        if (lkVar.isCancelled()) {
            future.cancel(true);
        }
    }
}
