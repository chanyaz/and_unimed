package com.google.android.gms.internal.measurement;

final class fl implements Runnable {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ eu b;

    fl(eu euVar, zzdz zzdz) {
        this.b = euVar;
        this.a = zzdz;
    }

    public final void run() {
        this.b.a.D();
        this.b.a.c(this.a);
    }
}
