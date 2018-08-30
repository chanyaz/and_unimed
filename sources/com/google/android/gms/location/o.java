package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class o implements Creator<LocationSettingsRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzae zzae = null;
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        boolean z2 = false;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    list = SafeParcelReader.c(parcel, a, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    zzae = (zzae) SafeParcelReader.a(parcel, a, zzae.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new LocationSettingsRequest(list, z2, z, zzae);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
