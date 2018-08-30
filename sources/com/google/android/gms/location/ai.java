package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.a;
import com.google.android.gms.internal.location.ag;

public final class ai extends a implements zzx {
    ai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    public final void onLocationChanged(Location location) {
        Parcel a = a();
        ag.a(a, (Parcelable) location);
        c(1, a);
    }
}
