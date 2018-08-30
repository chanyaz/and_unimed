package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.a;

public abstract class ala extends afb implements zzlj {
    public ala() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zza();
                parcel2.writeNoException();
                break;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 3:
                zzt(parcel.readString());
                parcel2.writeNoException();
                break;
            case 4:
                setAppMuted(afc.a(parcel));
                parcel2.writeNoException();
                break;
            case 5:
                zzb(a.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zza(parcel.readString(), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 7:
                float zzdo = zzdo();
                parcel2.writeNoException();
                parcel2.writeFloat(zzdo);
                break;
            case 8:
                boolean zzdp = zzdp();
                parcel2.writeNoException();
                afc.a(parcel2, zzdp);
                break;
            default:
                return false;
        }
        return true;
    }
}
