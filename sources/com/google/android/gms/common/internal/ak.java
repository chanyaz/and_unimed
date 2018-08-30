package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class ak extends b implements IResolveAccountCallbacks {
    public ak() {
        super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }

    public static IResolveAccountCallbacks a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        return queryLocalInterface instanceof IResolveAccountCallbacks ? (IResolveAccountCallbacks) queryLocalInterface : new al(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        onAccountResolutionComplete((ResolveAccountResponse) c.a(parcel, ResolveAccountResponse.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
