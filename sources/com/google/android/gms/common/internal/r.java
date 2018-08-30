package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class r implements Creator<ConnectionInfo> {
    /* renamed from: a */
    public ConnectionInfo createFromParcel(Parcel parcel) {
        Feature[] featureArr = null;
        int b = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 2:
                    featureArr = (Feature[]) SafeParcelReader.b(parcel, a, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new ConnectionInfo(bundle, featureArr);
    }

    /* renamed from: a */
    public ConnectionInfo[] newArray(int i) {
        return new ConnectionInfo[i];
    }
}
