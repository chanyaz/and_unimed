package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class fu implements Callable<String> {
    private final /* synthetic */ fq a;

    fu(fq fqVar) {
        this.a = fqVar;
    }

    public final /* synthetic */ Object call() {
        Object s = this.a.n().s();
        if (s == null) {
            fn e = this.a.e();
            if (e.zzgd().s()) {
                e.zzge().r().a("Cannot retrieve app instance id from analytics worker thread");
                s = null;
            } else {
                e.zzgd();
                if (en.r()) {
                    e.zzge().r().a("Cannot retrieve app instance id from main thread");
                    s = null;
                } else {
                    long elapsedRealtime = e.zzbt().elapsedRealtime();
                    s = e.c(120000);
                    elapsedRealtime = e.zzbt().elapsedRealtime() - elapsedRealtime;
                    if (s == null && elapsedRealtime < 120000) {
                        s = e.c(120000 - elapsedRealtime);
                    }
                }
            }
            if (s == null) {
                throw new TimeoutException();
            }
            this.a.n().d(s);
        }
        return s;
    }
}
