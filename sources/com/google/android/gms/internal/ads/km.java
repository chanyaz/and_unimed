package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class km implements Creator<zzang> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        String str = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    i = SafeParcelReader.e(parcel, a);
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
        return new zzang(str, i2, i, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzang[i];
    }
}
