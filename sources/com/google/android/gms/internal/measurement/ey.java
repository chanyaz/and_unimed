package com.google.android.gms.internal.measurement;

final class ey implements Runnable {
    private final /* synthetic */ zzed a;
    private final /* synthetic */ eu b;

    ey(eu euVar, zzed zzed) {
        this.b = euVar;
        this.a = zzed;
    }

    public final void run() {
        this.b.a.D();
        hw a = this.b.a;
        zzed zzed = this.a;
        zzdz a2 = a.a(zzed.a);
        if (a2 != null) {
            a.b(zzed, a2);
        }
    }
}
