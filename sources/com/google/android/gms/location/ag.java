package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.a;

public final class ag extends a implements zzu {
    ag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        Parcel a = a();
        com.google.android.gms.internal.location.ag.a(a, (Parcelable) locationAvailability);
        c(2, a);
    }

    public final void onLocationResult(LocationResult locationResult) {
        Parcel a = a();
        com.google.android.gms.internal.location.ag.a(a, (Parcelable) locationResult);
        c(1, a);
    }
}
