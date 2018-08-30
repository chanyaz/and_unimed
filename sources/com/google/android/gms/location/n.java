package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class n implements Creator<zzae> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = "";
        String str2 = "";
        String str3 = "";
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 2:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzae(str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzae[i];
    }
}
