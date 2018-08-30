package com.google.android.gms.internal.ads;

@zzadh
final class mu implements Runnable {
    private mg a;
    private boolean b = false;

    mu(mg mgVar) {
        this.a = mgVar;
    }

    private final void c() {
        ht.a.removeCallbacks(this);
        ht.a.postDelayed(this, 250);
    }

    public final void a() {
        this.b = true;
    }

    public final void b() {
        this.b = false;
        c();
    }

    public final void run() {
        if (!this.b) {
            this.a.h();
            c();
        }
    }
}
