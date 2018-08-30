package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.c;

final class fj implements Runnable {
    private final /* synthetic */ zzxq a;
    private final /* synthetic */ zzjj b;
    private final /* synthetic */ fn c;
    private final /* synthetic */ fh d;

    fj(fh fhVar, zzxq zzxq, zzjj zzjj, fn fnVar) {
        this.d = fhVar;
        this.a = zzxq;
        this.b = zzjj;
        this.c = fnVar;
    }

    public final void run() {
        try {
            this.a.zza(c.a(this.d.c), this.b, null, this.c, this.d.g);
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Fail to initialize adapter ";
            String valueOf = String.valueOf(this.d.a);
            kk.c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            this.d.zza(this.d.a, 0);
        }
    }
}
