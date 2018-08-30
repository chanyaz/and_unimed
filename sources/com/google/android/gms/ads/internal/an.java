package com.google.android.gms.ads.internal;

import android.os.Handler;

public final class an {
    private final Handler a;

    public an(Handler handler) {
        this.a = handler;
    }

    public final void a(Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }

    public final boolean a(Runnable runnable, long j) {
        return this.a.postDelayed(runnable, j);
    }
}
