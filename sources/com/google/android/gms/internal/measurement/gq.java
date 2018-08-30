package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class gq implements Runnable {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ go b;

    gq(go goVar, zzdz zzdz) {
        this.b = goVar;
        this.a = zzdz;
    }

    public final void run() {
        zzey d = this.b.b;
        if (d == null) {
            this.b.zzge().r().a("Failed to reset data on the service; null service");
            return;
        }
        try {
            d.zzd(this.a);
        } catch (RemoteException e) {
            this.b.zzge().r().a("Failed to reset data on the service", e);
        }
        this.b.y();
    }
}
