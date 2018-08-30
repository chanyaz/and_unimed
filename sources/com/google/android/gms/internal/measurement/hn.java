package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.support.annotation.WorkerThread;

final class hn extends cy {
    private final /* synthetic */ hm a;

    hn(hm hmVar, zzhi zzhi) {
        this.a = hmVar;
        super(zzhi);
    }

    @WorkerThread
    public final void a() {
        fn fnVar = this.a;
        fnVar.c();
        fnVar.zzge().y().a("Session started, time", Long.valueOf(fnVar.zzbt().elapsedRealtime()));
        fnVar.n().m.a(false);
        fnVar.e().b("auto", "_s", new Bundle());
        fnVar.n().n.a(fnVar.zzbt().currentTimeMillis());
    }
}
