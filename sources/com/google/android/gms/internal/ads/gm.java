package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class gm implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    gm(gj gjVar) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(SCION_TASK_EXECUTOR) #" + this.a.getAndIncrement());
    }
}
