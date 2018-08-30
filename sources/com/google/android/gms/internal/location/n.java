package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class n extends w implements zzaq {
    public n() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza((LocationSettingsResult) ag.a(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
