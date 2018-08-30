package com.google.android.gms.internal.ads;

final /* synthetic */ class aqo implements Runnable {
    private final aqn a;
    private final aqh b;
    private final lk c;
    private final zzsg d;

    aqo(aqn aqn, aqh aqh, lk lkVar, zzsg zzsg) {
        this.a = aqn;
        this.b = aqh;
        this.c = lkVar;
        this.d = zzsg;
    }

    public final void run() {
        aqn aqn = this.a;
        aqh aqh = this.b;
        lk lkVar = this.c;
        try {
            lkVar.b(aqh.r().zza(this.d));
        } catch (Throwable e) {
            kk.b("Unable to obtain a cache service instance.", e);
            lkVar.a(e);
            aqn.a.a();
        }
    }
}
