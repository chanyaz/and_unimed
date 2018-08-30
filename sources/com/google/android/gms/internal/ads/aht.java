package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aht implements Creator<zzhl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 6:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 7:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzhl(str4, j2, str3, str2, str, bundle, z, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzhl[i];
    }
}
