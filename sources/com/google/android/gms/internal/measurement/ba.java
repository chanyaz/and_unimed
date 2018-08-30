package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

final class ba implements Callable<String> {
    private final /* synthetic */ ay a;

    ba(ay ayVar) {
        this.a = ayVar;
    }

    public final /* synthetic */ Object call() {
        return this.a.e();
    }
}
