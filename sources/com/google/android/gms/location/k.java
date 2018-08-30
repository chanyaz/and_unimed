package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class k implements Creator<LocationRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i2 = MoPubClientPositioning.NO_REPEAT;
        float f = 0.0f;
        long j4 = 0;
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
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    j3 = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 7:
                    f = SafeParcelReader.j(parcel, a);
                    break;
                case 8:
                    j4 = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new LocationRequest(i, j, j2, z, j3, i2, f, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
