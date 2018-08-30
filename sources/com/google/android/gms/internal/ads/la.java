package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzadh
final class la<T> implements zzanz<T> {
    private final T a;
    private final lc b = new lc();

    la(T t) {
        this.a = t;
        this.b.a();
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final T get() {
        return this.a;
    }

    public final T get(long j, TimeUnit timeUnit) {
        return this.a;
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
