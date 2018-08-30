package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@zzadh
final class le<V> extends FutureTask<V> implements zzanz<V> {
    private final lc a = new lc();

    le(Runnable runnable, @Nullable V v) {
        super(runnable, v);
    }

    le(Callable<V> callable) {
        super(callable);
    }

    protected final void done() {
        this.a.a();
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.a.a(runnable, executor);
    }
}
