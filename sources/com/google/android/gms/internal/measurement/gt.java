package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class gt implements Runnable {
    private final /* synthetic */ gk a;
    private final /* synthetic */ go b;

    gt(go goVar, gk gkVar) {
        this.b = goVar;
        this.a = gkVar;
    }

    public final void run() {
        zzey d = this.b.b;
        if (d == null) {
            this.b.zzge().r().a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.a == null) {
                d.zza(0, null, null, this.b.getContext().getPackageName());
            } else {
                d.zza(this.a.c, this.a.a, this.a.b, this.b.getContext().getPackageName());
            }
            this.b.y();
        } catch (RemoteException e) {
            this.b.zzge().r().a("Failed to send current screen to the service", e);
        }
    }
}
