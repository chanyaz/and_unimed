package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

final class at implements Runnable {
    private final /* synthetic */ AtomicInteger a;
    private final /* synthetic */ int b;
    private final /* synthetic */ lk c;
    private final /* synthetic */ List d;

    at(AtomicInteger atomicInteger, int i, lk lkVar, List list) {
        this.a = atomicInteger;
        this.b = i;
        this.c = lkVar;
        this.d = list;
    }

    public final void run() {
        Throwable e;
        if (this.a.incrementAndGet() >= this.b) {
            try {
                this.c.b(am.b(this.d));
                return;
            } catch (ExecutionException e2) {
                e = e2;
            } catch (InterruptedException e3) {
                e = e3;
            }
        } else {
            return;
        }
        kk.c("Unable to convert list of futures to a future of list", e);
    }
}
