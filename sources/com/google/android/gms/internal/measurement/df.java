package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class df implements Creator<zzeu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = SafeParcelReader.b(parcel);
        long j = 0;
        zzer zzer = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    zzer = (zzer) SafeParcelReader.a(parcel, a, zzer.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzeu(str2, zzer, str, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzeu[i];
    }
}
