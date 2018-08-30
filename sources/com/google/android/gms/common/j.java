package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class j implements Creator<GoogleCertificatesQuery> {
    /* renamed from: a */
    public GoogleCertificatesQuery createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 2:
                    iBinder = SafeParcelReader.p(parcel, a);
                    break;
                case 3:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new GoogleCertificatesQuery(str, iBinder, z);
    }

    /* renamed from: a */
    public GoogleCertificatesQuery[] newArray(int i) {
        return new GoogleCertificatesQuery[i];
    }
}
