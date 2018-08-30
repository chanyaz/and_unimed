package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.au;
import java.util.concurrent.Executor;

final class lg implements Executor {
    private final Handler a = new hm(Looper.getMainLooper());

    lg() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                au.e();
                ht.a(au.i().m(), th);
            }
        } else {
            this.a.post(runnable);
        }
    }
}
