package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@Beta
public abstract class c extends AbstractExecutorService implements ListeningExecutorService {
    /* renamed from: a */
    protected final <T> o<T> newTaskFor(Runnable runnable, T t) {
        return o.a(runnable, t);
    }

    /* renamed from: a */
    protected final <T> o<T> newTaskFor(Callable<T> callable) {
        return o.a(callable);
    }

    public ListenableFuture<?> submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    public <T> ListenableFuture<T> submit(Runnable runnable, @Nullable T t) {
        return (ListenableFuture) super.submit(runnable, t);
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return (ListenableFuture) super.submit(callable);
    }
}
