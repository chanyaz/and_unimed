package com.google.android.gms.internal.measurement;

final class hf implements Runnable {
    private final /* synthetic */ zzey a;
    private final /* synthetic */ hc b;

    hf(hc hcVar, zzey zzey) {
        this.b = hcVar;
        this.a = zzey;
    }

    public final void run() {
        synchronized (this.b) {
            this.b.b = false;
            if (!this.b.a.r()) {
                this.b.a.zzge().x().a("Connected to remote service");
                this.b.a.a(this.a);
            }
        }
    }
}
