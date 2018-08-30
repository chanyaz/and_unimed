package com.google.android.gms.internal.ads;

import android.content.Context;

final class hv implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ ht b;

    hv(ht htVar, Context context) {
        this.b = htVar;
        this.a = context;
    }

    public final void run() {
        synchronized (this.b.b) {
            this.b.d = ht.d(this.a);
            this.b.b.notifyAll();
        }
    }
}
