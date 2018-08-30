package com.google.android.gms.internal.measurement;

final class fj implements Runnable {
    private final /* synthetic */ zzjx a;
    private final /* synthetic */ zzdz b;
    private final /* synthetic */ eu c;

    fj(eu euVar, zzjx zzjx, zzdz zzdz) {
        this.c = euVar;
        this.a = zzjx;
        this.b = zzdz;
    }

    public final void run() {
        this.c.a.D();
        this.c.a.a(this.a, this.b);
    }
}
