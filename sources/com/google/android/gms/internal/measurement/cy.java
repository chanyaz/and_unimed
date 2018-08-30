package com.google.android.gms.internal.measurement;

import android.os.Handler;
import com.google.android.gms.common.internal.ar;

abstract class cy {
    private static volatile Handler b;
    private final zzhi a;
    private final Runnable c;
    private volatile long d;

    cy(zzhi zzhi) {
        ar.a((Object) zzhi);
        this.a = zzhi;
        this.c = new cz(this, zzhi);
    }

    private final Handler d() {
        if (b != null) {
            return b;
        }
        Handler handler;
        synchronized (cy.class) {
            if (b == null) {
                b = new Handler(this.a.getContext().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public abstract void a();

    public final void a(long j) {
        c();
        if (j >= 0) {
            this.d = this.a.zzbt().currentTimeMillis();
            if (!d().postDelayed(this.c, j)) {
                this.a.zzge().r().a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean b() {
        return this.d != 0;
    }

    final void c() {
        this.d = 0;
        d().removeCallbacks(this.c);
    }
}
