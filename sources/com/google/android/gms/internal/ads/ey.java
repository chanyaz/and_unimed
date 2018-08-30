package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.a;

public abstract class ey extends afb implements zzagz {
    public ey() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzagz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzagz ? (zzagz) queryLocalInterface : new ez(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzagx zzagx = null;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                zza((zzahk) afc.a(parcel, zzahk.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                show();
                parcel2.writeNoException();
                break;
            case 3:
                zzahe fcVar;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    fcVar = queryLocalInterface instanceof zzahe ? (zzahe) queryLocalInterface : new fc(readStrongBinder);
                }
                zza(fcVar);
                parcel2.writeNoException();
                break;
            case 5:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                afc.a(parcel2, isLoaded);
                break;
            case 6:
                pause();
                parcel2.writeNoException();
                break;
            case 7:
                resume();
                parcel2.writeNoException();
                break;
            case 8:
                destroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzd(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                zze(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                zzf(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 13:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                break;
            case 14:
                zza(akr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                Parcelable zzba = zzba();
                parcel2.writeNoException();
                afc.b(parcel2, zzba);
                break;
            case 16:
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                    zzagx = queryLocalInterface instanceof zzagx ? (zzagx) queryLocalInterface : new ew(readStrongBinder);
                }
                zza(zzagx);
                parcel2.writeNoException();
                break;
            case 34:
                setImmersiveMode(afc.a(parcel));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
