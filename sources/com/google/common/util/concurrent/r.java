package com.google.common.util.concurrent;

import com.google.common.base.s;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class r extends c {
    private final ExecutorService a;

    r(ExecutorService executorService) {
        this.a = (ExecutorService) s.a((Object) executorService);
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.a.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    public void shutdown() {
        this.a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }
}
