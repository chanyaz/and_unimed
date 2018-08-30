package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

public abstract class ft extends afb implements zzaic {
    public ft() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzaic a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return queryLocalInterface instanceof zzaic ? (zzaic) queryLocalInterface : new fu(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzq(a.a(parcel.readStrongBinder()));
                break;
            case 2:
                zzc(a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzr(a.a(parcel.readStrongBinder()));
                break;
            case 4:
                zzs(a.a(parcel.readStrongBinder()));
                break;
            case 5:
                zzt(a.a(parcel.readStrongBinder()));
                break;
            case 6:
                zzu(a.a(parcel.readStrongBinder()));
                break;
            case 7:
                zza(a.a(parcel.readStrongBinder()), (zzaig) afc.a(parcel, zzaig.CREATOR));
                break;
            case 8:
                zzv(a.a(parcel.readStrongBinder()));
                break;
            case 9:
                zzd(a.a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzw(a.a(parcel.readStrongBinder()));
                break;
            case 11:
                zzx(a.a(parcel.readStrongBinder()));
                break;
            case 12:
                zzc((Bundle) afc.a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
