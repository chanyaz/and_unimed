package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class a implements Creator<GoogleSignInOptionsExtensionParcelable> {
    /* renamed from: a */
    public GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        int i = 0;
        int b = SafeParcelReader.b(parcel);
        Bundle bundle = null;
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
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new GoogleSignInOptionsExtensionParcelable(i2, i, bundle);
    }

    /* renamed from: a */
    public GoogleSignInOptionsExtensionParcelable[] newArray(int i) {
        return new GoogleSignInOptionsExtensionParcelable[i];
    }
}
