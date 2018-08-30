package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class gf implements Creator<zzaiq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        boolean z2 = false;
        List list2 = null;
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 4:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    list2 = SafeParcelReader.B(parcel, a);
                    break;
                case 7:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    list = SafeParcelReader.B(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzaiq(str2, str, z4, z3, list2, z2, z, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaiq[i];
    }
}
