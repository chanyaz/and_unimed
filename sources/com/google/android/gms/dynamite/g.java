package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class g extends a implements IDynamiteLoaderV2 {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a.writeByteArray(bArr);
        a = a(1, a);
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) {
        Parcel a = a();
        c.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a.writeInt(i);
        c.a(a, (IInterface) iObjectWrapper2);
        a = a(2, a);
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
