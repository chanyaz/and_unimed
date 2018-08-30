package com.google.android.gms.analytics;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class u extends ThreadPoolExecutor {
    final /* synthetic */ t a;

    public u(t tVar) {
        this.a = tVar;
        super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
        setThreadFactory(new v());
        allowCoreThreadTimeOut(true);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new y(this, runnable, t);
    }
}
