package com.puzzlersworld.android.util;

import android.app.Application;
import android.os.Handler;
import com.google.common.collect.fb;
import com.google.common.util.concurrent.c;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class v extends c {
    private final Handler a;

    public v(Application application) {
        this.a = new Handler(application.getMainLooper());
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public void shutdown() {
    }

    public List<Runnable> shutdownNow() {
        return fb.a();
    }
}
