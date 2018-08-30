package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class amc extends Thread {
    private final BlockingQueue<apk<?>> a;
    private final zzm b;
    private final zzb c;
    private final zzaa d;
    private volatile boolean e = false;

    public amc(BlockingQueue<apk<?>> blockingQueue, zzm zzm, zzb zzb, zzaa zzaa) {
        this.a = blockingQueue;
        this.b = zzm;
        this.c = zzb;
        this.d = zzaa;
    }

    private final void b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        apk apk = (apk) this.a.take();
        try {
            apk.b("network-queue-take");
            apk.g();
            TrafficStats.setThreadStatsTag(apk.d());
            any zzc = this.b.zzc(apk);
            apk.b("network-http-complete");
            if (zzc.e && apk.l()) {
                apk.c("not-modified");
                apk.m();
                return;
            }
            auj a = apk.a(zzc);
            apk.b("network-parse-complete");
            if (apk.h() && a.b != null) {
                this.c.zza(apk.e(), a.b);
                apk.b("network-cache-written");
            }
            apk.k();
            this.d.zzb(apk, a);
            apk.a(a);
        } catch (zzae e) {
            e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.zza(apk, e);
            apk.m();
        } catch (Throwable e2) {
            dc.a(e2, "Unhandled exception %s", e2.toString());
            zzae zzae = new zzae(e2);
            zzae.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.zza(apk, zzae);
            apk.m();
        }
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException e) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
