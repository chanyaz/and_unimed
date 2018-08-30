package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class aa extends b implements IAccountAccessor {
    public aa() {
        super("com.google.android.gms.common.internal.IAccountAccessor");
    }

    public static IAccountAccessor a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return queryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) queryLocalInterface : new ab(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        Parcelable account = getAccount();
        parcel2.writeNoException();
        c.b(parcel2, account);
        return true;
    }
}
