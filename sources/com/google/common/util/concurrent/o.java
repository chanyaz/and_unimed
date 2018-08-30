package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public class o<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final f a = new f();

    o(Runnable runnable, @Nullable V v) {
        super(runnable, v);
    }

    o(Callable<V> callable) {
        super(callable);
    }

    public static <V> o<V> a(Runnable runnable, @Nullable V v) {
        return new o(runnable, v);
    }

    public static <V> o<V> a(Callable<V> callable) {
        return new o(callable);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.a.a(runnable, executor);
    }

    protected void done() {
        this.a.a();
    }
}
