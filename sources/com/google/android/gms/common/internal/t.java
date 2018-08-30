package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class t implements Creator<GetServiceRequest> {
    /* renamed from: a */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        Feature[] featureArr = null;
        int b = SafeParcelReader.b(parcel);
        Feature[] featureArr2 = null;
        Account account = null;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i = 0;
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
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    iBinder = SafeParcelReader.p(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.a(parcel, a, Account.CREATOR);
                    break;
                case 10:
                    featureArr2 = (Feature[]) SafeParcelReader.b(parcel, a, Feature.CREATOR);
                    break;
                case 11:
                    featureArr = (Feature[]) SafeParcelReader.b(parcel, a, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, featureArr2, featureArr, z);
    }

    /* renamed from: a */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
