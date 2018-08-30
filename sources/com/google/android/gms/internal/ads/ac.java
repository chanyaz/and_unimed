package com.google.android.gms.internal.ads;

final class ac implements Runnable {
    private final /* synthetic */ gr a;
    private final /* synthetic */ aa b;

    ac(aa aaVar, gr grVar) {
        this.b = aaVar;
        this.a = grVar;
    }

    public final void run() {
        synchronized (this.b.c) {
            aa aaVar = this.b;
            aaVar.a.zzb(this.a);
        }
    }
}
