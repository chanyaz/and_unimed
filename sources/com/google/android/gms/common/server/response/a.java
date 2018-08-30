package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class a implements Creator<Field> {
    /* renamed from: a */
    public Field createFromParcel(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i4 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 5:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 7:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 8:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) SafeParcelReader.a(parcel, a, ConverterWrapper.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
    }

    /* renamed from: a */
    public Field[] newArray(int i) {
        return new Field[i];
    }
}
