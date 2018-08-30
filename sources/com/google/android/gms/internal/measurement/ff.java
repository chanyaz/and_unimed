package com.google.android.gms.internal.measurement;

final class ff implements Runnable {
    private final /* synthetic */ zzeu a;
    private final /* synthetic */ zzdz b;
    private final /* synthetic */ eu c;

    ff(eu euVar, zzeu zzeu, zzdz zzdz) {
        this.c = euVar;
        this.a = zzeu;
        this.b = zzdz;
    }

    public final void run() {
        this.c.a.D();
        this.c.a.a(this.a, this.b);
    }
}
