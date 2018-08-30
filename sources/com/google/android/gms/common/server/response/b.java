package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;

public class b implements Creator<FieldMapPair> {
    /* renamed from: a */
    public FieldMapPair createFromParcel(Parcel parcel) {
        Field field = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    field = (Field) SafeParcelReader.a(parcel, a, Field.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new FieldMapPair(i, str, field);
    }

    /* renamed from: a */
    public FieldMapPair[] newArray(int i) {
        return new FieldMapPair[i];
    }
}
