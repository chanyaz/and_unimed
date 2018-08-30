package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class am extends b implements ISignInButtonCreator {
    public am() {
        super("com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public static ISignInButtonCreator a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof ISignInButtonCreator ? (ISignInButtonCreator) queryLocalInterface : new an(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface newSignInButton;
        switch (i) {
            case 1:
                newSignInButton = newSignInButton(a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                c.a(parcel2, newSignInButton);
                break;
            case 2:
                newSignInButton = newSignInButtonFromConfig(a.a(parcel.readStrongBinder()), (SignInButtonConfig) c.a(parcel, SignInButtonConfig.CREATOR));
                parcel2.writeNoException();
                c.a(parcel2, newSignInButton);
                break;
            default:
                return false;
        }
        return true;
    }
}
