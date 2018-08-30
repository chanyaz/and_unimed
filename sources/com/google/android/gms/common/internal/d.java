package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class d implements Creator<AuthAccountRequest> {
    /* renamed from: a */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        Account account = null;
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        Integer num = null;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = SafeParcelReader.f(parcel, a);
                    break;
                case 5:
                    num = SafeParcelReader.f(parcel, a);
                    break;
                case 6:
                    account = (Account) SafeParcelReader.a(parcel, a, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new AuthAccountRequest(i, iBinder, scopeArr, num2, num, account);
    }

    /* renamed from: a */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
