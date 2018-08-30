package com.google.android.gms.internal.measurement;

final class ha implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ zzjx b;
    private final /* synthetic */ zzdz c;
    private final /* synthetic */ go d;

    ha(go goVar, boolean z, zzjx zzjx, zzdz zzdz) {
        this.d = goVar;
        this.a = z;
        this.b = zzjx;
        this.c = zzdz;
    }

    public final void run() {
        zzey d = this.d.b;
        if (d == null) {
            this.d.zzge().r().a("Discarding data. Failed to set user attribute");
            return;
        }
        this.d.a(d, this.a ? null : this.b, this.c);
        this.d.y();
    }
}
