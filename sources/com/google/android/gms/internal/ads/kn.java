package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@zzadh
public abstract class kn extends AbstractExecutorService implements zzaod {
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new le(runnable, t);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new le(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return (zzanz) super.submit(runnable, obj);
    }

    /* renamed from: zza */
    public final <T> zzanz<T> submit(Callable<T> callable) {
        return (zzanz) super.submit(callable);
    }

    /* renamed from: zze */
    public final zzanz<?> submit(Runnable runnable) {
        return (zzanz) super.submit(runnable);
    }
}
