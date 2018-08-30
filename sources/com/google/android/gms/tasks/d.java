package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class d implements Executor {
    private final Handler a = new Handler(Looper.getMainLooper());

    public final void execute(@NonNull Runnable runnable) {
        this.a.post(runnable);
    }
}
