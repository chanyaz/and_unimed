package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class ab implements Creator<zzj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = true;
        long j = 50;
        float f = 0.0f;
        long j2 = Long.MAX_VALUE;
        int i = MoPubClientPositioning.NO_REPEAT;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    f = SafeParcelReader.j(parcel, a);
                    break;
                case 4:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzj(z, j, f, j2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
