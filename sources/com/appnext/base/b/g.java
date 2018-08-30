package com.appnext.base.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class g {
    private static g jT;
    private static Context mContext;
    private Handler hP;
    private Handler jU = new Handler(Looper.getMainLooper());
    private HandlerThread jV = new HandlerThread("ExecutesManagerWorkerThread");

    public g() {
        this.jV.start();
        this.hP = new Handler(this.jV.getLooper());
    }

    public static g cC() {
        if (jT == null) {
            synchronized (g.class) {
                if (jT == null) {
                    jT = new g();
                }
            }
        }
        return jT;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            this.jU.post(runnable);
        }
    }

    public void a(Runnable runnable, long j) {
        if (runnable != null) {
            this.jU.postDelayed(runnable, j);
        }
    }

    public void b(Runnable runnable) {
        if (runnable != null) {
            this.hP.post(runnable);
        }
    }

    public void b(Runnable runnable, long j) {
        if (runnable != null) {
            this.hP.postDelayed(runnable, j);
        }
    }

    protected void finalize() {
        try {
            this.hP.removeCallbacks(null);
            this.jV.quit();
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
