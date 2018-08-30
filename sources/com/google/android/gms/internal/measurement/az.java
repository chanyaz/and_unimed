package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

final class az implements Callable<String> {
    private final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public final /* synthetic */ Object call() {
        return this.a.d();
    }
}
