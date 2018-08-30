package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class awi extends afa implements zzzh {
    awi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    public final void zzbr(String str) {
        Parcel a = a();
        a.writeString(str);
        b(3, a);
    }
}
