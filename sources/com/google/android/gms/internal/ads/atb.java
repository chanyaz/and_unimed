package com.google.android.gms.internal.ads;

final /* synthetic */ class atb implements Runnable {
    private final asy a;
    private final atp b;
    private final zzuu c;

    atb(asy asy, atp atp, zzuu zzuu) {
        this.a = asy;
        this.b = atp;
        this.c = zzuu;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
