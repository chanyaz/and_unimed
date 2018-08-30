package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class avd extends afa implements zzxw {
    avd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    public final int zzmm() {
        Parcel a = a(1, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
