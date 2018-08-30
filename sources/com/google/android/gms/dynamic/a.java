package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.stable.b;

public class a extends b implements IObjectWrapper {
    public a() {
        super("com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static IObjectWrapper a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return queryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) queryLocalInterface : new b(iBinder);
    }
}
