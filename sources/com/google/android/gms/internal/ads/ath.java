package com.google.android.gms.internal.ads;

final class ath implements zzaoo<zzuu> {
    private final /* synthetic */ atp a;
    private final /* synthetic */ asy b;

    ath(asy asy, atp atp) {
        this.b = asy;
        this.a = atp;
    }

    public final /* synthetic */ void zze(Object obj) {
        synchronized (this.b.a) {
            this.b.h = 0;
            if (!(this.b.g == null || this.a == this.b.g)) {
                hl.a("New JS engine is loaded, marking previous one as destroyable.");
                this.b.g.e();
            }
            this.b.g = this.a;
        }
    }
}
