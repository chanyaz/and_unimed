package com.google.common.util.concurrent;

import com.google.common.collect.cc;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class h<V> extends cc implements Future<V> {
    protected h() {
    }

    /* renamed from: a */
    protected abstract Future<V> b();

    public boolean cancel(boolean z) {
        return b().cancel(z);
    }

    public V get() {
        return b().get();
    }

    public V get(long j, TimeUnit timeUnit) {
        return b().get(j, timeUnit);
    }

    public boolean isCancelled() {
        return b().isCancelled();
    }

    public boolean isDone() {
        return b().isDone();
    }
}
