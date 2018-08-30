package com.google.android.gms.internal.ads;

final class ati implements zzaom {
    private final /* synthetic */ atp a;
    private final /* synthetic */ asy b;

    ati(asy asy, atp atp) {
        this.b = asy;
        this.a = atp;
    }

    public final void run() {
        synchronized (this.b.a) {
            this.b.h = 1;
            hl.a("Failed loading new engine. Marking new engine destroyable.");
            this.a.e();
        }
    }
}
