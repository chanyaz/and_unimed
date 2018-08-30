package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class eu extends afb implements zzagu {
    public eu() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String type = getType();
                parcel2.writeNoException();
                parcel2.writeString(type);
                break;
            case 2:
                int amount = getAmount();
                parcel2.writeNoException();
                parcel2.writeInt(amount);
                break;
            default:
                return false;
        }
        return true;
    }
}
