package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class aa implements Creator<zzbd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        List list = zzbd.a;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        LocationRequest locationRequest = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    locationRequest = (LocationRequest) SafeParcelReader.a(parcel, a, LocationRequest.CREATOR);
                    break;
                case 5:
                    list = SafeParcelReader.c(parcel, a, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 7:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 8:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 10:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzbd(locationRequest, list, str2, z3, z2, z, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbd[i];
    }
}
