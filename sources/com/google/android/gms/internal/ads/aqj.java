package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class aqj implements Creator<zzsi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String[] strArr = null;
        int b = SafeParcelReader.b(parcel);
        long j = 0;
        String[] strArr2 = null;
        byte[] bArr = null;
        int i = 0;
        String str = null;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    bArr = SafeParcelReader.r(parcel, a);
                    break;
                case 5:
                    strArr2 = SafeParcelReader.z(parcel, a);
                    break;
                case 6:
                    strArr = SafeParcelReader.z(parcel, a);
                    break;
                case 7:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 8:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzsi(z2, str, i, bArr, strArr2, strArr, z, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzsi[i];
    }
}
