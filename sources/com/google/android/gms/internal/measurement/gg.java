package com.google.android.gms.internal.measurement;

final class gg implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ fq b;

    gg(fq fqVar, long j) {
        this.b = fqVar;
        this.a = j;
    }

    public final void run() {
        this.b.n().k.a(this.a);
        this.b.zzge().x().a("Minimum session duration set", Long.valueOf(this.a));
    }
}
