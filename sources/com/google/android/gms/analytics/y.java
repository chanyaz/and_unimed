package com.google.android.gms.analytics;

import android.util.Log;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.FutureTask;

final class y extends FutureTask<T> {
    private final /* synthetic */ u a;

    y(u uVar, Runnable runnable, Object obj) {
        this.a = uVar;
        super(runnable, obj);
    }

    protected final void setException(Throwable th) {
        UncaughtExceptionHandler b = this.a.a.g;
        if (b != null) {
            b.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th);
            Log.e("GAv4", new StringBuilder(String.valueOf(valueOf).length() + 37).append("MeasurementExecutor: job failed with ").append(valueOf).toString());
        }
        super.setException(th);
    }
}
