package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class cu extends afb implements zzaen {
    public cu() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzaet zzaet = null;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        zzaey zzaey;
        switch (i) {
            case 1:
                Parcelable zzb = zzb((zzaef) afc.a(parcel, zzaef.CREATOR));
                parcel2.writeNoException();
                afc.b(parcel2, zzb);
                break;
            case 2:
                zzaeq cxVar;
                zzaef zzaef = (zzaef) afc.a(parcel, zzaef.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    cxVar = queryLocalInterface instanceof zzaeq ? (zzaeq) queryLocalInterface : new cx(readStrongBinder);
                }
                zza(zzaef, cxVar);
                parcel2.writeNoException();
                break;
            case 4:
                zzaey = (zzaey) afc.a(parcel, zzaey.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzaet = queryLocalInterface instanceof zzaet ? (zzaet) queryLocalInterface : new cy(readStrongBinder);
                }
                zza(zzaey, zzaet);
                parcel2.writeNoException();
                break;
            case 5:
                zzaey = (zzaey) afc.a(parcel, zzaey.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzaet = queryLocalInterface instanceof zzaet ? (zzaet) queryLocalInterface : new cy(readStrongBinder);
                }
                zzb(zzaey, zzaet);
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
