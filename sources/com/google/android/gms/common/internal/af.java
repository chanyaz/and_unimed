package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class af extends a implements IGmsCallbacks {
    af(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public void onAccountValidationComplete(int i, Bundle bundle) {
        Parcel a = a();
        a.writeInt(i);
        c.a(a, (Parcelable) bundle);
        b(2, a);
    }

    public void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
        Parcel a = a();
        a.writeInt(i);
        a.writeStrongBinder(iBinder);
        c.a(a, (Parcelable) bundle);
        b(1, a);
    }

    public void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo) {
        Parcel a = a();
        a.writeInt(i);
        a.writeStrongBinder(iBinder);
        c.a(a, (Parcelable) connectionInfo);
        b(3, a);
    }
}
