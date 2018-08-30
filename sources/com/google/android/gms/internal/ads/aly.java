package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aly implements Creator<zzmu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzmu(z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmu[i];
    }
}
