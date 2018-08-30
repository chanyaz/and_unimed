package com.google.android.gms.analytics;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class v implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger();

    private v() {
    }

    /* synthetic */ v(x xVar) {
        this();
    }

    public final Thread newThread(Runnable runnable) {
        return new w(runnable, "measurement-" + a.incrementAndGet());
    }
}
