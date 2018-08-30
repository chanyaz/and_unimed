package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class lh implements Executor {
    lh() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
