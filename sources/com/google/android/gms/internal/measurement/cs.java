package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class cs implements Creator<zzed> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        zzjx zzjx = null;
        long j = 0;
        boolean z = false;
        String str3 = null;
        zzeu zzeu = null;
        long j2 = 0;
        zzeu zzeu2 = null;
        long j3 = 0;
        zzeu zzeu3 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 4:
                    zzjx = (zzjx) SafeParcelReader.a(parcel, a, zzjx.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 7:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    zzeu = (zzeu) SafeParcelReader.a(parcel, a, zzeu.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    zzeu2 = (zzeu) SafeParcelReader.a(parcel, a, zzeu.CREATOR);
                    break;
                case 11:
                    j3 = SafeParcelReader.g(parcel, a);
                    break;
                case 12:
                    zzeu3 = (zzeu) SafeParcelReader.a(parcel, a, zzeu.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzed(str, str2, zzjx, j, z, str3, zzeu, j2, zzeu2, j3, zzeu3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzed[i];
    }
}
