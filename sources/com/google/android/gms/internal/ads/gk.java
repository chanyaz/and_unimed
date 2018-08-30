package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class gk implements Callable {
    private final gj a;
    private final Context b;

    gk(gj gjVar, Context context) {
        this.a = gjVar;
        this.b = context;
    }

    public final Object call() {
        return this.a.k(this.b);
    }
}
