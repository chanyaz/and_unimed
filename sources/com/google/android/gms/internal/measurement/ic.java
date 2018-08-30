package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ic implements Creator<zzjx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Double d = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    l = SafeParcelReader.h(parcel, a);
                    break;
                case 5:
                    f = SafeParcelReader.k(parcel, a);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 7:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    d = SafeParcelReader.m(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzjx(i, str3, j, l, f, str2, str, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjx[i];
    }
}
