package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;

final class bc implements Callable<String> {
    private final /* synthetic */ ay a;

    bc(ay ayVar) {
        this.a = ayVar;
    }

    public final /* synthetic */ Object call() {
        return this.a.e.d.a().zza(this.a.e.c);
    }
}
