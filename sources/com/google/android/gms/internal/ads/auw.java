package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class auw extends afb implements zzxn {
    public auw() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzxn a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzxn ? (zzxn) queryLocalInterface : new aux(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzbm;
        switch (i) {
            case 1:
                zzbm = zzbm(parcel.readString());
                parcel2.writeNoException();
                afc.a(parcel2, zzbm);
                break;
            case 2:
                boolean zzbn = zzbn(parcel.readString());
                parcel2.writeNoException();
                afc.a(parcel2, zzbn);
                break;
            case 3:
                zzbm = zzbq(parcel.readString());
                parcel2.writeNoException();
                afc.a(parcel2, zzbm);
                break;
            default:
                return false;
        }
        return true;
    }
}
