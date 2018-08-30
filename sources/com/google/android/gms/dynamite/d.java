package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class d extends b implements IDynamiteLoader {
    public d() {
        super("com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public static IDynamiteLoader a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
        return queryLocalInterface instanceof IDynamiteLoader ? (IDynamiteLoader) queryLocalInterface : new e(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        int moduleVersion;
        switch (i) {
            case 1:
                moduleVersion = getModuleVersion(a.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(moduleVersion);
                break;
            case 2:
                IInterface createModuleContext = createModuleContext(a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                c.a(parcel2, createModuleContext);
                break;
            case 3:
                moduleVersion = getModuleVersion2(a.a(parcel.readStrongBinder()), parcel.readString(), c.a(parcel));
                parcel2.writeNoException();
                parcel2.writeInt(moduleVersion);
                break;
            default:
                return false;
        }
        return true;
    }
}
