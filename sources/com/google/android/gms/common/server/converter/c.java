package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;

public class c implements Creator<Entry> {
    /* renamed from: a */
    public Entry createFromParcel(Parcel parcel) {
        int i = 0;
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new Entry(i2, str, i);
    }

    /* renamed from: a */
    public Entry[] newArray(int i) {
        return new Entry[i];
    }
}
