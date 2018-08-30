package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class adp extends Thread {
    private static final boolean a = dc.a;
    private final BlockingQueue<apk<?>> b;
    private final BlockingQueue<apk<?>> c;
    private final zzb d;
    private final zzaa e;
    private volatile boolean f = false;
    private final afo g;

    public adp(BlockingQueue<apk<?>> blockingQueue, BlockingQueue<apk<?>> blockingQueue2, zzb zzb, zzaa zzaa) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = zzb;
        this.e = zzaa;
        this.g = new afo(this);
    }

    private final void b() {
        apk apk = (apk) this.b.take();
        apk.b("cache-queue-take");
        apk.g();
        acs zza = this.d.zza(apk.e());
        if (zza == null) {
            apk.b("cache-miss");
            if (!this.g.a(apk)) {
                this.c.put(apk);
            }
        } else if (zza.a()) {
            apk.b("cache-hit-expired");
            apk.a(zza);
            if (!this.g.a(apk)) {
                this.c.put(apk);
            }
        } else {
            apk.b("cache-hit");
            auj a = apk.a(new any(zza.a, zza.g));
            apk.b("cache-hit-parsed");
            if (zza.f < System.currentTimeMillis()) {
                apk.b("cache-hit-refresh-needed");
                apk.a(zza);
                a.d = true;
                if (!this.g.a(apk)) {
                    this.e.zza(apk, a, new aeq(this, apk));
                    return;
                }
            }
            this.e.zzb(apk, a);
        }
    }

    public final void a() {
        this.f = true;
        interrupt();
    }

    public final void run() {
        if (a) {
            dc.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.zza();
        while (true) {
            try {
                b();
            } catch (InterruptedException e) {
                if (this.f) {
                    return;
                }
            }
        }
    }
}
