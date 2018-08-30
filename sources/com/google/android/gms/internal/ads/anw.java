package com.google.android.gms.internal.ads;

final class anw implements Runnable {
    private final /* synthetic */ anv a;

    anw(anv anv) {
        this.a = anv;
    }

    public final void run() {
        if (this.a.q != null) {
            this.a.q.zzkq();
            this.a.q.zzkp();
            this.a.q.zzcs();
        }
        this.a.q = null;
    }
}
