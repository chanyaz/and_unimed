package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class d implements Creator<Feature> {
    /* renamed from: a */
    public Feature createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 2:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new Feature(str, i, j);
    }

    /* renamed from: a */
    public Feature[] newArray(int i) {
        return new Feature[i];
    }
}
