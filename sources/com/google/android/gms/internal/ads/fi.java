package com.google.android.gms.internal.ads;

final class fi implements Runnable {
    private final /* synthetic */ zzjj a;
    private final /* synthetic */ zzxq b;
    private final /* synthetic */ fh c;

    fi(fh fhVar, zzjj zzjj, zzxq zzxq) {
        this.c = fhVar;
        this.a = zzjj;
        this.b = zzxq;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
