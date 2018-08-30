package com.google.common.util.concurrent;

import com.google.common.base.s;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

class k<I, O> extends a<O> implements Runnable {
    private AsyncFunction<? super I, ? extends O> a;
    private ListenableFuture<? extends I> b;
    private volatile ListenableFuture<? extends O> c;
    private final CountDownLatch d;

    private k(AsyncFunction<? super I, ? extends O> asyncFunction, ListenableFuture<? extends I> listenableFuture) {
        this.d = new CountDownLatch(1);
        this.a = (AsyncFunction) s.a((Object) asyncFunction);
        this.b = (ListenableFuture) s.a((Object) listenableFuture);
    }

    private void a(@Nullable Future<?> future, boolean z) {
        if (future != null) {
            future.cancel(z);
        }
    }

    public boolean cancel(boolean z) {
        if (!super.cancel(z)) {
            return false;
        }
        a(this.b, z);
        a(this.c, z);
        return true;
    }

    public void run() {
        try {
            try {
                final ListenableFuture apply = this.a.apply(z.a(this.b));
                this.c = apply;
                if (isCancelled()) {
                    apply.cancel(b());
                    this.c = null;
                    return;
                }
                apply.addListener(new Runnable() {
                    public void run() {
                        try {
                            k.this.a(z.a(apply));
                        } catch (CancellationException e) {
                            k.this.cancel(false);
                        } catch (ExecutionException e2) {
                            k.this.a(e2.getCause());
                        } finally {
                            k.this.c = null;
                        }
                    }
                }, p.a());
                this.a = null;
                this.b = null;
                this.d.countDown();
            } catch (UndeclaredThrowableException e) {
                a(e.getCause());
            } catch (Throwable th) {
                a(th);
            } finally {
                this.a = null;
                this.b = null;
                this.d.countDown();
            }
        } catch (CancellationException e2) {
            cancel(false);
            this.a = null;
            this.b = null;
            this.d.countDown();
        } catch (ExecutionException e3) {
            a(e3.getCause());
            this.a = null;
            this.b = null;
            this.d.countDown();
        }
    }
}
