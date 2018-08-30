package com.google.common.util.concurrent;

import com.google.common.base.s;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class m<V> implements ListenableFuture<V> {
    private static final Logger a = Logger.getLogger(m.class.getName());

    private m() {
    }

    public void addListener(Runnable runnable, Executor executor) {
        s.a((Object) runnable, (Object) "Runnable was null.");
        s.a((Object) executor, (Object) "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Throwable e) {
            a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public abstract V get();

    public V get(long j, TimeUnit timeUnit) {
        s.a((Object) timeUnit);
        return get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
