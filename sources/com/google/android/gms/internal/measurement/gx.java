package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;

final class gx implements Runnable {
    private final /* synthetic */ boolean a = true;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzed c;
    private final /* synthetic */ zzdz d;
    private final /* synthetic */ zzed e;
    private final /* synthetic */ go f;

    gx(go goVar, boolean z, boolean z2, zzed zzed, zzdz zzdz, zzed zzed2) {
        this.f = goVar;
        this.b = z2;
        this.c = zzed;
        this.d = zzdz;
        this.e = zzed2;
    }

    public final void run() {
        zzey d = this.f.b;
        if (d == null) {
            this.f.zzge().r().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.a) {
            this.f.a(d, this.b ? null : this.c, this.d);
        } else {
            try {
                if (TextUtils.isEmpty(this.e.a)) {
                    d.zza(this.c, this.d);
                } else {
                    d.zzb(this.c);
                }
            } catch (RemoteException e) {
                this.f.zzge().r().a("Failed to send conditional user property to the service", e);
            }
        }
        this.f.y();
    }
}
