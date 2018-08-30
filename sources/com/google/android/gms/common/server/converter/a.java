package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class a implements Creator<ConverterWrapper> {
    /* renamed from: a */
    public ConverterWrapper createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    stringToIntConverter = (StringToIntConverter) SafeParcelReader.a(parcel, a, StringToIntConverter.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new ConverterWrapper(i, stringToIntConverter);
    }

    /* renamed from: a */
    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
