package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class ev extends afa implements zzagu {
    ev(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    public final int getAmount() {
        Parcel a = a(2, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final String getType() {
        Parcel a = a(1, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
