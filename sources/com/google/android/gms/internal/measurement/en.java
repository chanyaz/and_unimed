package com.google.android.gms.internal.measurement;

import android.os.Looper;
import com.google.android.gms.common.internal.ar;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class en extends fo {
    private static final AtomicLong k = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService a;
    private er b;
    private er c;
    private final PriorityBlockingQueue<eq<?>> d = new PriorityBlockingQueue();
    private final BlockingQueue<eq<?>> e = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f = new ep(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler g = new ep(this, "Thread death: Uncaught exception on network thread");
    private final Object h = new Object();
    private final Semaphore i = new Semaphore(2);
    private volatile boolean j;

    en(es esVar) {
        super(esVar);
    }

    private final void a(eq<?> eqVar) {
        synchronized (this.h) {
            this.d.add(eqVar);
            if (this.b == null) {
                this.b = new er(this, "Measurement Worker", this.d);
                this.b.setUncaughtExceptionHandler(this.f);
                this.b.start();
            } else {
                this.b.a();
            }
        }
    }

    public static boolean r() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    final <T> T a(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        String valueOf;
        synchronized (atomicReference) {
            zzgd().a(runnable);
            try {
                atomicReference.wait(15000);
            } catch (InterruptedException e) {
                dr u = zzge().u();
                String str2 = "Interrupted waiting for ";
                valueOf = String.valueOf(str);
                u.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            dr u2 = zzge().u();
            String str3 = "Timed out waiting for ";
            valueOf = String.valueOf(str);
            u2.a(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        return t;
    }

    public final <V> Future<V> a(Callable<V> callable) {
        B();
        ar.a((Object) callable);
        eq eqVar = new eq(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.b) {
            if (!this.d.isEmpty()) {
                zzge().u().a("Callable skipped the worker queue.");
            }
            eqVar.run();
        } else {
            a(eqVar);
        }
        return eqVar;
    }

    public final void a(Runnable runnable) {
        B();
        ar.a((Object) runnable);
        a(new eq(this, runnable, false, "Task exception on worker thread"));
    }

    public final <V> Future<V> b(Callable<V> callable) {
        B();
        ar.a((Object) callable);
        eq eqVar = new eq(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.b) {
            eqVar.run();
        } else {
            a(eqVar);
        }
        return eqVar;
    }

    public final void b() {
        if (Thread.currentThread() != this.c) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void b(Runnable runnable) {
        B();
        ar.a((Object) runnable);
        eq eqVar = new eq(this, runnable, false, "Task exception on network thread");
        synchronized (this.h) {
            this.e.add(eqVar);
            if (this.c == null) {
                this.c = new er(this, "Measurement Network", this.e);
                this.c.setUncaughtExceptionHandler(this.g);
                this.c.start();
            } else {
                this.c.a();
            }
        }
    }

    public final void c() {
        if (Thread.currentThread() != this.b) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    protected final boolean p() {
        return false;
    }

    public final boolean s() {
        return Thread.currentThread() == this.b;
    }

    final ExecutorService t() {
        ExecutorService executorService;
        synchronized (this.h) {
            if (this.a == null) {
                this.a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.a;
        }
        return executorService;
    }
}
