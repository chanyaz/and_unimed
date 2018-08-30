package com.google.android.gms.common.api.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class k extends b implements IStatusCallback {
    public k() {
        super("com.google.android.gms.common.api.internal.IStatusCallback");
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        onResult((Status) c.a(parcel, Status.CREATOR));
        return true;
    }
}
