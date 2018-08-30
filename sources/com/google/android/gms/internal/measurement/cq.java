package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class cq implements Creator<zzdz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = true;
        boolean z2 = false;
        long j3 = -2147483648L;
        String str6 = null;
        long j4 = 0;
        long j5 = 0;
        int i = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 6:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 7:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 8:
                    str5 = SafeParcelReader.o(parcel, a);
                    break;
                case 9:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 10:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 11:
                    j3 = SafeParcelReader.g(parcel, a);
                    break;
                case 12:
                    str6 = SafeParcelReader.o(parcel, a);
                    break;
                case 13:
                    j4 = SafeParcelReader.g(parcel, a);
                    break;
                case 14:
                    j5 = SafeParcelReader.g(parcel, a);
                    break;
                case 15:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 16:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 17:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 18:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzdz(str, str2, str3, str4, j, j2, str5, z, z2, j3, str6, j4, j5, i, z3, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdz[i];
    }
}
