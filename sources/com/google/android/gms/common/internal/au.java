package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class au implements Creator<SignInButtonConfig> {
    /* renamed from: a */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int i = 0;
        int b = SafeParcelReader.b(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new SignInButtonConfig(i3, i2, i, scopeArr);
    }

    /* renamed from: a */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
