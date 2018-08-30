package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.ag;
import com.google.android.gms.internal.location.w;

public abstract class ah extends w implements zzx {
    public ah() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static zzx a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof zzx ? (zzx) queryLocalInterface : new ai(iBinder);
    }

    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        onLocationChanged((Location) ag.a(parcel, Location.CREATOR));
        return true;
    }
}
