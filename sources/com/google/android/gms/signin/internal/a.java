package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class a implements Creator<AuthAccountResult> {
    /* renamed from: a */
    public AuthAccountResult createFromParcel(Parcel parcel) {
        int i = 0;
        int b = SafeParcelReader.b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    intent = (Intent) SafeParcelReader.a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new AuthAccountResult(i2, i, intent);
    }

    /* renamed from: a */
    public AuthAccountResult[] newArray(int i) {
        return new AuthAccountResult[i];
    }
}
