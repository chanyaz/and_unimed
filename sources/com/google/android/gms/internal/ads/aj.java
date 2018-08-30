package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.r;
import java.util.concurrent.CountDownLatch;

final class aj implements Runnable {
    private final /* synthetic */ CountDownLatch a;
    private final /* synthetic */ ai b;

    aj(ai aiVar, CountDownLatch countDownLatch) {
        this.b = aiVar;
        this.a = countDownLatch;
    }

    public final void run() {
        synchronized (this.b.d) {
            this.b.m = r.a(this.b.l, this.b.g, this.a);
        }
    }
}
