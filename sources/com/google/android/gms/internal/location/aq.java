package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aq implements Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        zzm zzm = null;
        int i = 1;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    zzm = (zzm) SafeParcelReader.a(parcel, a, zzm.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.p(parcel, a);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.p(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzo(i, zzm, iBinder, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
