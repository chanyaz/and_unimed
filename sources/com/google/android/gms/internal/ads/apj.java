package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class apj extends afa implements zzqw {
    apj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zza(zzqk zzqk) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqk);
        b(1, a);
    }
}
