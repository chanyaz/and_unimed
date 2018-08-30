package com.google.android.gms.internal.measurement;

import java.lang.Thread.UncaughtExceptionHandler;

final class ai implements UncaughtExceptionHandler {
    private final /* synthetic */ ah a;

    ai(ah ahVar) {
        this.a = ahVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        ae f = this.a.f();
        if (f != null) {
            f.e("Job execution failed", th);
        }
    }
}
