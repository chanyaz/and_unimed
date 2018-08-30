package com.google.common.util.concurrent;

import com.google.common.base.s;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class a<V> implements ListenableFuture<V> {
    private final b<V> a = new b();
    private final f b = new f();

    protected a() {
    }

    static final CancellationException a(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    protected void a() {
    }

    protected boolean a(@Nullable V v) {
        boolean a = this.a.a((Object) v);
        if (a) {
            this.b.a();
        }
        return a;
    }

    protected boolean a(Throwable th) {
        boolean a = this.a.a((Throwable) s.a((Object) th));
        if (a) {
            this.b.a();
        }
        return a;
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }

    protected final boolean b() {
        return this.a.d();
    }

    public boolean cancel(boolean z) {
        if (!this.a.a(z)) {
            return false;
        }
        this.b.a();
        if (z) {
            a();
        }
        return true;
    }

    public V get() {
        return this.a.a();
    }

    public V get(long j, TimeUnit timeUnit) {
        return this.a.a(timeUnit.toNanos(j));
    }

    public boolean isCancelled() {
        return this.a.c();
    }

    public boolean isDone() {
        return this.a.b();
    }
}
