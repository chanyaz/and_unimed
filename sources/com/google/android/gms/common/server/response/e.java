package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class e implements Creator<SafeParcelResponse> {
    /* renamed from: a */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    parcel2 = SafeParcelReader.C(parcel, a);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) SafeParcelReader.a(parcel, a, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
    }

    /* renamed from: a */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
