package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class q implements Creator<zzaq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    z6 = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    f = SafeParcelReader.j(parcel, a);
                    break;
                case 7:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 8:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 10:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzaq(z6, z5, str, z4, f, i, z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaq[i];
    }
}
