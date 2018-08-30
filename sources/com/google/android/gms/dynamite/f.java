package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class f extends b implements IDynamiteLoaderV2 {
    public f() {
        super("com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public static IDynamiteLoaderV2 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        return queryLocalInterface instanceof IDynamiteLoaderV2 ? (IDynamiteLoaderV2) queryLocalInterface : new g(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface loadModule;
        switch (i) {
            case 1:
                loadModule = loadModule(a.a(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                c.a(parcel2, loadModule);
                break;
            case 2:
                loadModule = loadModule2(a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                c.a(parcel2, loadModule);
                break;
            default:
                return false;
        }
        return true;
    }
}
