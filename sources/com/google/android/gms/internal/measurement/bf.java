package com.google.android.gms.internal.measurement;

import android.os.Handler;
import com.google.android.gms.common.internal.ar;

abstract class bf {
    private static volatile Handler b;
    private final ah a;
    private final Runnable c = new bg(this);
    private volatile long d;

    bf(ah ahVar) {
        ar.a((Object) ahVar);
        this.a = ahVar;
    }

    private final Handler e() {
        if (b != null) {
            return b;
        }
        Handler handler;
        synchronized (bf.class) {
            if (b == null) {
                b = new Handler(this.a.a().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public abstract void a();

    public final void a(long j) {
        d();
        if (j >= 0) {
            this.d = this.a.c().currentTimeMillis();
            if (!e().postDelayed(this.c, j)) {
                this.a.e().e("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final long b() {
        return this.d == 0 ? 0 : Math.abs(this.a.c().currentTimeMillis() - this.d);
    }

    public final void b(long j) {
        long j2 = 0;
        if (!c()) {
            return;
        }
        if (j < 0) {
            d();
            return;
        }
        long abs = j - Math.abs(this.a.c().currentTimeMillis() - this.d);
        if (abs >= 0) {
            j2 = abs;
        }
        e().removeCallbacks(this.c);
        if (!e().postDelayed(this.c, j2)) {
            this.a.e().e("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }

    public final boolean c() {
        return this.d != 0;
    }

    public final void d() {
        this.d = 0;
        e().removeCallbacks(this.c);
    }
}
