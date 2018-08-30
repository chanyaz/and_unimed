package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class ajp implements Creator<zzjj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzmq zzmq = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 5:
                    list = SafeParcelReader.B(parcel, a);
                    break;
                case 6:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 7:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 8:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 10:
                    zzmq = (zzmq) SafeParcelReader.a(parcel, a, zzmq.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.a(parcel, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.q(parcel, a);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.q(parcel, a);
                    break;
                case 15:
                    list2 = SafeParcelReader.B(parcel, a);
                    break;
                case 16:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 17:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 18:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzjj(i, j, bundle, i2, list, z, i3, z2, str, zzmq, location, str2, bundle2, bundle3, list2, str3, str4, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjj[i];
    }
}
