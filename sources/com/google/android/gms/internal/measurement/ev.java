package com.google.android.gms.internal.measurement;

final class ev implements Runnable {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ eu b;

    ev(eu euVar, zzdz zzdz) {
        this.b = euVar;
        this.a = zzdz;
    }

    public final void run() {
        this.b.a.D();
        this.b.a.a(this.a);
    }
}
