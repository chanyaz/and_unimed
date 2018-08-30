package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public abstract class i<V> extends h<V> implements ListenableFuture<V> {
    protected i() {
    }

    public void addListener(Runnable runnable, Executor executor) {
        b().addListener(runnable, executor);
    }

    /* renamed from: c */
    protected abstract ListenableFuture<V> b();
}
