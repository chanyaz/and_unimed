package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class al extends a implements IResolveAccountCallbacks {
    al(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }

    public void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse) {
        Parcel a = a();
        c.a(a, (Parcelable) resolveAccountResponse);
        b(2, a);
    }
}
