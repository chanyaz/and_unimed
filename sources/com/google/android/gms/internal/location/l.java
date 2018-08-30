package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;

public abstract class l extends w implements zzam {
    public l() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zza(parcel.readInt(), parcel.createStringArray());
                break;
            case 2:
                zzb(parcel.readInt(), parcel.createStringArray());
                break;
            case 3:
                zza(parcel.readInt(), (PendingIntent) ag.a(parcel, PendingIntent.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
