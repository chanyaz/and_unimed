package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class k implements Creator<SignInResponse> {
    /* renamed from: a */
    public SignInResponse createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    connectionResult = (ConnectionResult) SafeParcelReader.a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 3:
                    resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.a(parcel, a, ResolveAccountResponse.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new SignInResponse(i, connectionResult, resolveAccountResponse);
    }

    /* renamed from: a */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
