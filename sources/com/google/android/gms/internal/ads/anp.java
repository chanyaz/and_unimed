package com.google.android.gms.internal.ads;

final class anp implements Runnable {
    private final /* synthetic */ ano a;

    anp(ano ano) {
        this.a = ano;
    }

    public final void run() {
        if (this.a.p != null) {
            this.a.p.zzkq();
            this.a.p.zzkp();
            this.a.p.zzcs();
        }
        this.a.p = null;
    }
}
