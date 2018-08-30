package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class a implements Creator<ConnectionEvent> {
    /* renamed from: a */
    public ConnectionEvent createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 6:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 7:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    str5 = SafeParcelReader.o(parcel, a);
                    break;
                case 10:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 11:
                    j3 = SafeParcelReader.g(parcel, a);
                    break;
                case 12:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 13:
                    str6 = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
    }

    /* renamed from: a */
    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
