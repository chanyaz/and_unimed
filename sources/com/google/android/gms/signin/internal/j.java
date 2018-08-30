package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class j implements Creator<SignInRequest> {
    /* renamed from: a */
    public SignInRequest createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) SafeParcelReader.a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new SignInRequest(i, resolveAccountRequest);
    }

    /* renamed from: a */
    public SignInRequest[] newArray(int i) {
        return new SignInRequest[i];
    }
}
