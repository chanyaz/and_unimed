package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.ar;

@zzadh
public final class jn {
    private HandlerThread a = null;
    private Handler b = null;
    private int c = 0;
    private final Object d = new Object();

    public final Looper a() {
        Looper looper;
        synchronized (this.d) {
            if (this.c != 0) {
                ar.a(this.a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.a == null) {
                hl.a("Starting the looper thread.");
                this.a = new HandlerThread("LooperProvider");
                this.a.start();
                this.b = new Handler(this.a.getLooper());
                hl.a("Looper thread started.");
            } else {
                hl.a("Resuming the looper thread");
                this.d.notifyAll();
            }
            this.c++;
            looper = this.a.getLooper();
        }
        return looper;
    }

    public final Handler b() {
        return this.b;
    }
}
