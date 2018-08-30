package com.google.android.gms.internal.measurement;

final class ek implements Runnable {
    private final /* synthetic */ es a;
    private final /* synthetic */ dp b;

    ek(ej ejVar, es esVar, dp dpVar) {
        this.a = esVar;
        this.b = dpVar;
    }

    public final void run() {
        if (this.a.f() == null) {
            this.b.r().a("Install Referrer Reporter is null");
        } else {
            this.a.f().a();
        }
    }
}
