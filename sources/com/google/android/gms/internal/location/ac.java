package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ac implements Creator<zzbh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i2 = 0;
        int i3 = -1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    s = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    d = SafeParcelReader.l(parcel, a);
                    break;
                case 5:
                    d2 = SafeParcelReader.l(parcel, a);
                    break;
                case 6:
                    f = SafeParcelReader.j(parcel, a);
                    break;
                case 7:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 8:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 9:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzbh(str, i, s, d, d2, f, j, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbh[i];
    }
}
