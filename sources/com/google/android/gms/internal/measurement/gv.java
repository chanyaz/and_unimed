package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class gv implements Runnable {
    private final /* synthetic */ zzdz a;
    private final /* synthetic */ go b;

    gv(go goVar, zzdz zzdz) {
        this.b = goVar;
        this.a = zzdz;
    }

    public final void run() {
        zzey d = this.b.b;
        if (d == null) {
            this.b.zzge().r().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            d.zzb(this.a);
            this.b.y();
        } catch (RemoteException e) {
            this.b.zzge().r().a("Failed to send measurementEnabled to the service", e);
        }
    }
}
