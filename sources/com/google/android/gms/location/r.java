package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class r implements Creator<zzaj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = -1;
        int i = 1;
        int b = SafeParcelReader.b(parcel);
        long j2 = -1;
        int i2 = 1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzaj(i2, i, j2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaj[i];
    }
}
