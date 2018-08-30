package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;

final class gw implements Runnable {
    private final /* synthetic */ boolean a = true;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzeu c;
    private final /* synthetic */ zzdz d;
    private final /* synthetic */ String e;
    private final /* synthetic */ go f;

    gw(go goVar, boolean z, boolean z2, zzeu zzeu, zzdz zzdz, String str) {
        this.f = goVar;
        this.b = z2;
        this.c = zzeu;
        this.d = zzdz;
        this.e = str;
    }

    public final void run() {
        zzey d = this.f.b;
        if (d == null) {
            this.f.zzge().r().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.a) {
            this.f.a(d, this.b ? null : this.c, this.d);
        } else {
            try {
                if (TextUtils.isEmpty(this.e)) {
                    d.zza(this.c, this.d);
                } else {
                    d.zza(this.c, this.e, this.f.zzge().z());
                }
            } catch (RemoteException e) {
                this.f.zzge().r().a("Failed to send event to the service", e);
            }
        }
        this.f.y();
    }
}
