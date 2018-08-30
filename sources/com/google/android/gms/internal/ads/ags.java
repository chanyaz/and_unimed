package com.google.android.gms.internal.ads;

final class ags implements Runnable {
    private final /* synthetic */ agr a;

    ags(agr agr) {
        this.a = agr;
    }

    public final void run() {
        synchronized (this.a.c) {
            if (this.a.d && this.a.e) {
                this.a.d = false;
                kk.b("App went background");
                for (zzgj zzh : this.a.f) {
                    try {
                        zzh.zzh(false);
                    } catch (Throwable e) {
                        kk.b("", e);
                    }
                }
            } else {
                kk.b("App is still foreground");
            }
        }
    }
}
