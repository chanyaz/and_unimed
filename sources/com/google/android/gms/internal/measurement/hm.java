package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

public final class hm extends fo {
    private Handler a;
    @VisibleForTesting
    private long b = zzbt().elapsedRealtime();
    private final cy c = new hn(this, this.q);
    private final cy d = new ho(this, this.q);

    hm(es esVar) {
        super(esVar);
    }

    @WorkerThread
    private final void a(long j) {
        c();
        s();
        this.c.c();
        this.d.c();
        zzge().y().a("Activity resumed, time", Long.valueOf(j));
        this.b = j;
        if (zzbt().currentTimeMillis() - n().l.a() > n().n.a()) {
            n().m.a(true);
            n().o.a(0);
        }
        if (n().m.a()) {
            this.c.a(Math.max(0, n().k.a() - n().o.a()));
        } else {
            this.d.a(Math.max(0, 3600000 - n().o.a()));
        }
    }

    @WorkerThread
    private final void b(long j) {
        c();
        s();
        this.c.c();
        this.d.c();
        zzge().y().a("Activity paused, time", Long.valueOf(j));
        if (this.b != 0) {
            n().o.a(n().o.a() + (j - this.b));
        }
    }

    private final void s() {
        synchronized (this) {
            if (this.a == null) {
                this.a = new Handler(Looper.getMainLooper());
            }
        }
    }

    @WorkerThread
    private final void t() {
        c();
        a(false);
        d().a(zzbt().elapsedRealtime());
    }

    @WorkerThread
    public final boolean a(boolean z) {
        c();
        B();
        long elapsedRealtime = zzbt().elapsedRealtime();
        n().n.a(zzbt().currentTimeMillis());
        long j = elapsedRealtime - this.b;
        if (z || j >= 1000) {
            n().o.a(j);
            zzge().y().a("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            gl.a(i().r(), bundle, true);
            e().a("auto", "_e", bundle);
            this.b = elapsedRealtime;
            this.d.c();
            this.d.a(Math.max(0, 3600000 - n().o.a()));
            return true;
        }
        zzge().y().a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    protected final boolean p() {
        return false;
    }

    final void r() {
        this.c.c();
        this.d.c();
        this.b = 0;
    }
}
