package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class j implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 1;
        int b = SafeParcelReader.b(parcel);
        int i2 = 1000;
        long j = 0;
        zzaj[] zzajArr = null;
        int i3 = 1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 5:
                    zzajArr = (zzaj[]) SafeParcelReader.b(parcel, a, zzaj.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new LocationAvailability(i2, i3, i, j, zzajArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
