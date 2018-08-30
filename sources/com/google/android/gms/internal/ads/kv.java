package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class kv implements Runnable {
    private final Future a;

    kv(Future future) {
        this.a = future;
    }

    public final void run() {
        Future future = this.a;
        if (!future.isDone()) {
            future.cancel(true);
        }
    }
}
