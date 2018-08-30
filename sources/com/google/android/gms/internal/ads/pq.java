package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class pq implements Creator<zzatt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    str2 = SafeParcelReader.o(parcel, a);
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
        return new zzatt(i, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzatt[i];
    }
}
