package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

public abstract class aot extends afb implements zzqa {
    public aot() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzqa a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof zzqa ? (zzqa) queryLocalInterface : new aou(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzb(parcel.readString(), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 2:
                IInterface zzak = zzak(parcel.readString());
                parcel2.writeNoException();
                afc.a(parcel2, zzak);
                break;
            case 3:
                zza(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 4:
                destroy();
                parcel2.writeNoException();
                break;
            case 5:
                zzb(a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                break;
            case 6:
                zzc(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
