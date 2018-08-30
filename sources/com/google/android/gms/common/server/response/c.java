package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class c implements Creator<FieldMappingDictionary> {
    /* renamed from: a */
    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        String str = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    arrayList = SafeParcelReader.c(parcel, a, Entry.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new FieldMappingDictionary(i, arrayList, str);
    }

    /* renamed from: a */
    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
