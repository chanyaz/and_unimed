package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

final class hz implements Callable<String> {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ hw b;

    hz(hw hwVar, zzdz zzdz) {
        this.b = hwVar;
        this.a = zzdz;
    }

    public final /* synthetic */ Object call() {
        cp a = this.b.b().i(this.a.a) ? this.b.e(this.a) : this.b.z().b(this.a.a);
        if (a != null) {
            return a.c();
        }
        this.b.zzge().u().a("App info was null when attempting to get app instance id");
        return null;
    }
}
