package com.google.android.gms.internal.measurement;

final class hd implements Runnable {
    private final /* synthetic */ zzey a;
    private final /* synthetic */ hc b;

    hd(hc hcVar, zzey zzey) {
        this.b = hcVar;
        this.a = zzey;
    }

    public final void run() {
        synchronized (this.b) {
            this.b.b = false;
            if (!this.b.a.r()) {
                this.b.a.zzge().y().a("Connected to service");
                this.b.a.a(this.a);
            }
        }
    }
}
