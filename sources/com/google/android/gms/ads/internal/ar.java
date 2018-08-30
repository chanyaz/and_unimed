package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.acz;
import com.google.android.gms.internal.ads.ada;
import java.util.concurrent.Callable;

final class ar implements Callable<ada> {
    private final /* synthetic */ ao a;

    ar(ao aoVar) {
        this.a = aoVar;
    }

    public final /* synthetic */ Object call() {
        return new ada(acz.a(this.a.a.a, this.a.d, false));
    }
}
