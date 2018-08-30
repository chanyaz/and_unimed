package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class h implements Creator<RecordConsentRequest> {
    /* renamed from: a */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        Scope[] scopeArr = null;
        Account account = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    account = (Account) SafeParcelReader.a(parcel, a, Account.CREATOR);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new RecordConsentRequest(i, account, scopeArr, str);
    }

    /* renamed from: a */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
