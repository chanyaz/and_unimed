package com.google.android.gms.internal.measurement;

final class fw implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ fq b;

    fw(fq fqVar, long j) {
        this.b = fqVar;
        this.a = j;
    }

    public final void run() {
        boolean z = true;
        fn fnVar = this.b;
        long j = this.a;
        fnVar.c();
        fnVar.B();
        fnVar.zzge().x().a("Resetting analytics data (FE)");
        fnVar.m().r();
        if (fnVar.o().j(fnVar.f().s())) {
            fnVar.n().h.a(j);
        }
        boolean t = fnVar.q.t();
        if (!fnVar.o().q()) {
            fnVar.n().d(!t);
        }
        fnVar.h().t();
        if (t) {
            z = false;
        }
        fnVar.b = z;
    }
}
