package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.a;

public abstract class and extends afb implements zzoa {
    public and() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        String zzjn;
        switch (i) {
            case 1:
                zzjn = zzjn();
                parcel2.writeNoException();
                parcel2.writeString(zzjn);
                break;
            case 2:
                zzjn = getContent();
                parcel2.writeNoException();
                parcel2.writeString(zzjn);
                break;
            case 3:
                zzg(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 4:
                recordClick();
                parcel2.writeNoException();
                break;
            case 5:
                recordImpression();
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
