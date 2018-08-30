package com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

final class b<V> extends AbstractQueuedSynchronizer {
    private static final long serialVersionUID = 0;
    private V a;
    private Throwable b;

    b() {
    }

    private boolean a(@Nullable V v, @Nullable Throwable th, int i) {
        boolean compareAndSetState = compareAndSetState(0, 1);
        if (compareAndSetState) {
            this.a = v;
            if ((i & 12) != 0) {
                th = new CancellationException("Future.cancel() was called.");
            }
            this.b = th;
            releaseShared(i);
        } else if (getState() == 1) {
            acquireShared(-1);
        }
        return compareAndSetState;
    }

    private V e() {
        int state = getState();
        switch (state) {
            case 2:
                if (this.b == null) {
                    return this.a;
                }
                throw new ExecutionException(this.b);
            case 4:
            case 8:
                throw a.a("Task was cancelled.", this.b);
            default:
                throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
        }
    }

    V a() {
        acquireSharedInterruptibly(-1);
        return e();
    }

    V a(long j) {
        if (tryAcquireSharedNanos(-1, j)) {
            return e();
        }
        throw new TimeoutException("Timeout waiting for task.");
    }

    boolean a(@Nullable V v) {
        return a(v, null, 2);
    }

    boolean a(Throwable th) {
        return a(null, th, 2);
    }

    boolean a(boolean z) {
        return a(null, null, z ? 8 : 4);
    }

    boolean b() {
        return (getState() & 14) != 0;
    }

    boolean c() {
        return (getState() & 12) != 0;
    }

    boolean d() {
        return getState() == 8;
    }

    protected int tryAcquireShared(int i) {
        return b() ? 1 : -1;
    }

    protected boolean tryReleaseShared(int i) {
        setState(i);
        return true;
    }
}
