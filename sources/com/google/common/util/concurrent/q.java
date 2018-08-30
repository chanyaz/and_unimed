package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.s;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
class q {
    q() {
    }

    final ScheduledExecutorService a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return a(scheduledThreadPoolExecutor, 120, TimeUnit.SECONDS);
    }

    final ScheduledExecutorService a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        p.b(scheduledThreadPoolExecutor);
        ExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        a(unconfigurableScheduledExecutorService, j, timeUnit);
        return unconfigurableScheduledExecutorService;
    }

    @VisibleForTesting
    void a(Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
    }

    final void a(ExecutorService executorService, long j, TimeUnit timeUnit) {
        s.a((Object) executorService);
        s.a((Object) timeUnit);
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        a(p.a("DelayedShutdownHook-for-" + executorService, new Runnable() {
            public void run() {
                try {
                    executorService2.shutdown();
                    executorService2.awaitTermination(j2, timeUnit2);
                } catch (InterruptedException e) {
                }
            }
        }));
    }
}
