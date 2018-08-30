package com.google.android.gms.internal.measurement;

final class gh implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ fq b;

    gh(fq fqVar, long j) {
        this.b = fqVar;
        this.a = j;
    }

    public final void run() {
        this.b.n().l.a(this.a);
        this.b.zzge().x().a("Session timeout duration set", Long.valueOf(this.a));
    }
}
