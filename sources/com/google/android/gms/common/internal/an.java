package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class an extends a implements ISignInButtonCreator {
    an(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        a.writeInt(i2);
        a = a(1, a);
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        c.a(a, (Parcelable) signInButtonConfig);
        a = a(2, a);
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
