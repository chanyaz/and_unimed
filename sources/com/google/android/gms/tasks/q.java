package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class q implements Executor {
    q() {
    }

    public final void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}
