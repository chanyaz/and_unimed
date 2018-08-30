package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public class lk<T> implements zzanz<T> {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private T b;
    @GuardedBy("mLock")
    private Throwable c;
    @GuardedBy("mLock")
    private boolean d;
    @GuardedBy("mLock")
    private boolean e;
    private final lc f = new lc();

    @GuardedBy("mLock")
    private final boolean a() {
        return this.c != null || this.d;
    }

    public final void a(Throwable th) {
        synchronized (this.a) {
            if (this.e) {
            } else if (a()) {
                au.i().b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
            } else {
                this.c = th;
                this.a.notifyAll();
                this.f.a();
            }
        }
    }

    public final void b(@Nullable T t) {
        synchronized (this.a) {
            if (this.e) {
            } else if (a()) {
                au.i().b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
            } else {
                this.d = true;
                this.b = t;
                this.a.notifyAll();
                this.f.a();
            }
        }
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.a) {
            if (a()) {
                return false;
            }
            this.e = true;
            this.d = true;
            this.a.notifyAll();
            this.f.a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.a) {
            if (!a()) {
                try {
                    this.a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            } else if (this.e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.b;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.a) {
            if (!a()) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            } else if (!this.d) {
                throw new TimeoutException("SettableFuture timed out.");
            } else if (this.e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.a) {
            z = this.e;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.a) {
            a = a();
        }
        return a;
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.f.a(runnable, executor);
    }
}
