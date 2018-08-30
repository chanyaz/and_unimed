package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

final class fh implements Callable<byte[]> {
    private final /* synthetic */ zzeu a;
    private final /* synthetic */ String b;
    private final /* synthetic */ eu c;

    fh(eu euVar, zzeu zzeu, String str) {
        this.c = euVar;
        this.a = zzeu;
        this.b = str;
    }

    public final /* synthetic */ Object call() {
        this.c.a.D();
        return this.c.a.b(this.a, this.b);
    }
}
