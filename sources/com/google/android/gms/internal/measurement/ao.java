package com.google.android.gms.internal.measurement;

final class ao implements Runnable {
    private final /* synthetic */ zzci a;
    private final /* synthetic */ an b;

    ao(an anVar, zzci zzci) {
        this.b = anVar;
        this.a = zzci;
    }

    public final void run() {
        if (!this.b.a.b()) {
            this.b.a.c("Connected to service after a timeout");
            this.b.a.a(this.a);
        }
    }
}
