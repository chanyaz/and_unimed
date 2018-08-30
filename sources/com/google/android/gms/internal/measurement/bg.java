package com.google.android.gms.internal.measurement;

import android.os.Looper;

final class bg implements Runnable {
    private final /* synthetic */ bf a;

    bg(bf bfVar) {
        this.a = bfVar;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.a.a.g().a((Runnable) this);
            return;
        }
        boolean c = this.a.c();
        this.a.d = 0;
        if (c) {
            this.a.a();
        }
    }
}
