package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public class c implements Creator<CheckServerAuthResult> {
    /* renamed from: a */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    list = SafeParcelReader.c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new CheckServerAuthResult(i, z, list);
    }

    /* renamed from: a */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
