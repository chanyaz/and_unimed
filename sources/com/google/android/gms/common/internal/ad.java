package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.a;

public class ad extends a implements ICertData {
    ad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public IObjectWrapper getBytesWrapped() {
        Parcel a = a(1, a());
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public int getHashCode() {
        Parcel a = a(2, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
