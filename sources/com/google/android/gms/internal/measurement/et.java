package com.google.android.gms.internal.measurement;

final class et implements Runnable {
    private final /* synthetic */ fp a;
    private final /* synthetic */ es b;

    et(es esVar, fp fpVar) {
        this.b = esVar;
        this.a = fpVar;
    }

    public final void run() {
        this.b.a(this.a);
        this.b.a();
    }
}
