package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class ew extends afa implements zzagx {
    ew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zza(zzagu zzagu, String str) {
        Parcel a = a();
        afc.a(a, (IInterface) zzagu);
        a.writeString(str);
        b(1, a);
    }
}
