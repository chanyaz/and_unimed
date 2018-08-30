package com.google.android.gms.internal.ads;

final /* synthetic */ class att implements Runnable {
    private final ats a;
    private final zzuu b;

    att(ats ats, zzuu zzuu) {
        this.a = ats;
        this.b = zzuu;
    }

    public final void run() {
        ats ats = this.a;
        zzuu zzuu = this.b;
        ats.a.b.zze(zzuu);
        zzuu.destroy();
    }
}
