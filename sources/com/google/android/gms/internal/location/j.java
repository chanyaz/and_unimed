package com.google.android.gms.internal.location;

import android.os.Parcel;

public abstract class j extends w implements zzaj {
    public j() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza((zzad) ag.a(parcel, zzad.CREATOR));
        return true;
    }
}
