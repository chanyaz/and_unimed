package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class at implements Creator<ResolveAccountResponse> {
    /* renamed from: a */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = SafeParcelReader.b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    iBinder = SafeParcelReader.p(parcel, a);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) SafeParcelReader.a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
    }

    /* renamed from: a */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
