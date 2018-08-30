package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class t implements Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        long j2 = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    list = SafeParcelReader.c(parcel, a, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 5:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new ActivityRecognitionResult(list, j2, j, i, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
