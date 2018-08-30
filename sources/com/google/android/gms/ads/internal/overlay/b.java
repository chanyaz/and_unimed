package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class b implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Intent intent = null;
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str7 = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    str6 = SafeParcelReader.o(parcel, a);
                    break;
                case 4:
                    str5 = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 6:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 9:
                    intent = (Intent) SafeParcelReader.a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzc(str7, str6, str5, str4, str3, str2, str, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
