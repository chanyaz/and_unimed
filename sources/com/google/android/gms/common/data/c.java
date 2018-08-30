package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class c implements Creator<DataHolder> {
    /* renamed from: a */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = SafeParcelReader.b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    strArr = SafeParcelReader.z(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) SafeParcelReader.b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 1000:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.a();
        return dataHolder;
    }

    /* renamed from: a */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
