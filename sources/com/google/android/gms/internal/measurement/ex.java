package com.google.android.gms.internal.measurement;

final class ex implements Runnable {
    private final /* synthetic */ zzed a;
    private final /* synthetic */ zzdz b;
    private final /* synthetic */ eu c;

    ex(eu euVar, zzed zzed, zzdz zzdz) {
        this.c = euVar;
        this.a = zzed;
        this.b = zzdz;
    }

    public final void run() {
        this.c.a.D();
        this.c.a.a(this.a, this.b);
    }
}
