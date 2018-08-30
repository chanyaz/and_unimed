package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class apm extends afa implements zzqz {
    apm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zza(zzqo zzqo) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqo);
        b(1, a);
    }
}
