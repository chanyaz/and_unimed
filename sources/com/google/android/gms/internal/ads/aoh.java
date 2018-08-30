package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aoh implements Creator<zzpl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = SafeParcelReader.b(parcel);
        zzmu zzmu = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 6:
                    zzmu = (zzmu) SafeParcelReader.a(parcel, a, zzmu.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzpl(i3, z2, i2, z, i, zzmu);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzpl[i];
    }
}
