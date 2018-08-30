package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.kk;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

final class z extends TimerTask {
    private final /* synthetic */ CountDownLatch a;
    private final /* synthetic */ Timer b;
    private final /* synthetic */ a c;

    z(a aVar, CountDownLatch countDownLatch, Timer timer) {
        this.c = aVar;
        this.a = countDownLatch;
        this.b = timer;
    }

    public final void run() {
        if (((long) ((Integer) akc.f().a(amn.cp)).intValue()) != this.a.getCount()) {
            kk.b("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.a.getCount() == 0) {
                this.b.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.c.e.c.getPackageName()).concat("_adsTrace_");
        try {
            kk.b("Starting method tracing");
            this.a.countDown();
            Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(au.l().currentTimeMillis()).toString(), ((Integer) akc.f().a(amn.cq)).intValue());
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
