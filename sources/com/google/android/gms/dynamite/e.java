package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class e extends a implements IDynamiteLoader {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public IObjectWrapper createModuleContext(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a.writeInt(i);
        a = a(2, a);
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public int getModuleVersion(IObjectWrapper iObjectWrapper, String str) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a = a(1, a);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public int getModuleVersion2(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        c.a(a, z);
        a = a(3, a);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
