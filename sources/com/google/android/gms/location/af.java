package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.ag;
import com.google.android.gms.internal.location.w;

public abstract class af extends w implements zzu {
    public af() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzu a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzu ? (zzu) queryLocalInterface : new ag(iBinder);
    }

    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onLocationResult((LocationResult) ag.a(parcel, LocationResult.CREATOR));
                break;
            case 2:
                onLocationAvailability((LocationAvailability) ag.a(parcel, LocationAvailability.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
