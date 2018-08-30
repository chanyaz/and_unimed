package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;

public abstract class awj extends afb implements zzzj {
    public awj() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzzj a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return queryLocalInterface instanceof zzzj ? (zzzj) queryLocalInterface : new awk(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzzh zzzh = null;
        Parcelable zznc;
        byte[] createByteArray;
        String readString;
        Bundle bundle;
        IObjectWrapper a;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                zzzm zzzm;
                IObjectWrapper a2 = a.a(parcel.readStrongBinder());
                String readString2 = parcel.readString();
                Bundle bundle2 = (Bundle) afc.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 == null) {
                    zzzm = null;
                } else {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    zzzm = queryLocalInterface2 instanceof zzzm ? (zzzm) queryLocalInterface2 : new awl(readStrongBinder2);
                }
                zza(a2, readString2, bundle2, zzzm);
                parcel2.writeNoException();
                break;
            case 2:
                zznc = zznc();
                parcel2.writeNoException();
                afc.b(parcel2, zznc);
                break;
            case 3:
                zznc = zznd();
                parcel2.writeNoException();
                afc.b(parcel2, zznc);
                break;
            case 4:
                zzzf awh;
                createByteArray = parcel.createByteArray();
                readString = parcel.readString();
                bundle = (Bundle) afc.a(parcel, Bundle.CREATOR);
                a = a.a(parcel.readStrongBinder());
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    awh = queryLocalInterface instanceof zzzf ? (zzzf) queryLocalInterface : new awh(readStrongBinder);
                }
                zza(createByteArray, readString, bundle, a, awh, ava.a(parcel.readStrongBinder()), (zzjn) afc.a(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                queryLocalInterface = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 6:
                createByteArray = parcel.createByteArray();
                readString = parcel.readString();
                bundle = (Bundle) afc.a(parcel, Bundle.CREATOR);
                a = a.a(parcel.readStrongBinder());
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    zzzh = queryLocalInterface instanceof zzzh ? (zzzh) queryLocalInterface : new awi(readStrongBinder);
                }
                zza(createByteArray, readString, bundle, a, zzzh, ava.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 7:
                showInterstitial();
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
