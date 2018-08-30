package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

final class fc implements Callable<List<zzed>> {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ eu d;

    fc(eu euVar, zzdz zzdz, String str, String str2) {
        this.d = euVar;
        this.a = zzdz;
        this.b = str;
        this.c = str2;
    }

    public final /* synthetic */ Object call() {
        this.d.a.D();
        return this.d.a.z().b(this.a.a, this.b, this.c);
    }
}
