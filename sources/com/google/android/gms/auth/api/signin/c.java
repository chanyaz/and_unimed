package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public class c implements Creator<GoogleSignInOptions> {
    /* renamed from: a */
    public GoogleSignInOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    arrayList2 = SafeParcelReader.c(parcel, a, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.a(parcel, a, Account.CREATOR);
                    break;
                case 4:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 9:
                    arrayList = SafeParcelReader.c(parcel, a, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new GoogleSignInOptions(i, arrayList2, account, z3, z2, z, str2, str, arrayList);
    }

    /* renamed from: a */
    public GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
