package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class awh extends afa implements zzzf {
    awh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    public final void zzbr(String str) {
        Parcel a = a();
        a.writeString(str);
        b(2, a);
    }
}
