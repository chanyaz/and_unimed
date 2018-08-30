package com.google.common.util.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class u<V> extends j<V> implements ListenableScheduledFuture<V> {
    private final ScheduledFuture<?> a;

    public u(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
        super(listenableFuture);
        this.a = scheduledFuture;
    }

    /* renamed from: a */
    public int compareTo(Delayed delayed) {
        return this.a.compareTo(delayed);
    }

    public boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.a.cancel(z);
        }
        return cancel;
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.a.getDelay(timeUnit);
    }
}
