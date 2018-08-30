package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class jb extends ix implements zzr {
    jb(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle zza(Bundle bundle) {
        Parcel a = a();
        iz.a(a, (Parcelable) bundle);
        Parcel a2 = a(1, a);
        Bundle bundle2 = (Bundle) iz.a(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle2;
    }
}
