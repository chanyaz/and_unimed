package com.google.common.util.concurrent;

import com.google.common.base.s;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class t extends r implements ListeningScheduledExecutorService {
    final ScheduledExecutorService a;

    t(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.a = (ScheduledExecutorService) s.a((Object) scheduledExecutorService);
    }

    public ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        Object a = o.a(runnable, null);
        return new u(a, this.a.schedule(a, j, timeUnit));
    }

    public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        Object a = o.a(callable);
        return new u(a, this.a.schedule(a, j, timeUnit));
    }

    public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Object vVar = new v(runnable);
        return new u(vVar, this.a.scheduleAtFixedRate(vVar, j, j2, timeUnit));
    }

    public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Object vVar = new v(runnable);
        return new u(vVar, this.a.scheduleWithFixedDelay(vVar, j, j2, timeUnit));
    }
}
