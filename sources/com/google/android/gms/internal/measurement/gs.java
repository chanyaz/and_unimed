package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class gs implements Runnable {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ go b;

    gs(go goVar, zzdz zzdz) {
        this.b = goVar;
        this.a = zzdz;
    }

    public final void run() {
        zzey d = this.b.b;
        if (d == null) {
            this.b.zzge().r().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            d.zza(this.a);
            this.b.a(d, null, this.a);
            this.b.y();
        } catch (RemoteException e) {
            this.b.zzge().r().a("Failed to send app launch to the service", e);
        }
    }
}
