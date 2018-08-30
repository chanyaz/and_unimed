package com.google.common.util.concurrent;

import com.google.common.util.concurrent.p.AnonymousClass1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class s extends c {
    private final Lock a;
    private final Condition b;
    private int c;
    private boolean d;

    private s() {
        this.a = new ReentrantLock();
        this.b = this.a.newCondition();
        this.c = 0;
        this.d = false;
    }

    /* synthetic */ s(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a() {
        this.a.lock();
        try {
            if (isShutdown()) {
                throw new RejectedExecutionException("Executor already shutdown");
            }
            this.c++;
        } finally {
            this.a.unlock();
        }
    }

    private void b() {
        this.a.lock();
        try {
            this.c--;
            if (isTerminated()) {
                this.b.signalAll();
            }
            this.a.unlock();
        } catch (Throwable th) {
            this.a.unlock();
        }
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        this.a.lock();
        while (!isTerminated()) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.b.awaitNanos(toNanos);
            } finally {
                this.a.unlock();
            }
        }
        this.a.unlock();
        return true;
    }

    public void execute(Runnable runnable) {
        a();
        try {
            runnable.run();
        } finally {
            b();
        }
    }

    public boolean isShutdown() {
        this.a.lock();
        try {
            boolean z = this.d;
            return z;
        } finally {
            this.a.unlock();
        }
    }

    public boolean isTerminated() {
        this.a.lock();
        try {
            boolean z = this.d && this.c == 0;
            this.a.unlock();
            return z;
        } catch (Throwable th) {
            this.a.unlock();
        }
    }

    public void shutdown() {
        this.a.lock();
        try {
            this.d = true;
        } finally {
            this.a.unlock();
        }
    }

    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }
}
