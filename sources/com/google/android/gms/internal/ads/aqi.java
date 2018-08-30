package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aqi implements Creator<zzsg> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int b = SafeParcelReader.b(parcel);
        String[] strArr2 = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 2:
                    strArr2 = SafeParcelReader.z(parcel, a);
                    break;
                case 3:
                    strArr = SafeParcelReader.z(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzsg(str, strArr2, strArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzsg[i];
    }
}
