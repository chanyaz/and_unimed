package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class akj extends afb implements zzkk {
    public akj() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        String mediationAdapterClassName;
        switch (i) {
            case 1:
                zzd((zzjj) afc.a(parcel, zzjj.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 3:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                afc.a(parcel2, isLoading);
                break;
            case 4:
                mediationAdapterClassName = zzck();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 5:
                zza((zzjj) afc.a(parcel, zzjj.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
