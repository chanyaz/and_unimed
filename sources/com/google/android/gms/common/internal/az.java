package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class az implements Creator<BinderWrapper> {
    az() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
