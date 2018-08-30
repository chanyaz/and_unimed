package com.google.android.gms.internal.ads;

final class cf implements Runnable {
    private final /* synthetic */ zzaol a;
    private final /* synthetic */ bw b;

    cf(bw bwVar, zzaol zzaol) {
        this.b = bwVar;
        this.a = zzaol;
    }

    public final void run() {
        synchronized (this.b.d) {
            this.b.a = this.b.a(this.b.c.j, this.a);
            if (this.b.a == null) {
                this.b.a(0, "Could not start the ad request service.");
                ht.a.removeCallbacks(this.b.i);
            }
        }
    }
}
