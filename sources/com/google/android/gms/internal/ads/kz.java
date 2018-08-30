package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzadh
final class kz<T> implements zzanz<T> {
    private final Throwable a;
    private final lc b = new lc();

    kz(Throwable th) {
        this.a = th;
        this.b.a();
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final T get() {
        throw new ExecutionException(this.a);
    }

    public final T get(long j, TimeUnit timeUnit) {
        throw new ExecutionException(this.a);
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }
}
