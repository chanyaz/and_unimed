package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class q implements Creator<LocationSettingsStates> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    z6 = SafeParcelReader.c(parcel, a);
                    break;
                case 2:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new LocationSettingsStates(z6, z5, z4, z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
