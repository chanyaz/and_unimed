package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ajr implements Creator<zzjn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzjn[] zzjnArr = null;
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    i4 = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 5:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 7:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 8:
                    zzjnArr = (zzjn[]) SafeParcelReader.b(parcel, a, zzjn.CREATOR);
                    break;
                case 9:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 10:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 11:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzjn(str, i4, i3, z4, i2, i, zzjnArr, z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjn[i];
    }
}
