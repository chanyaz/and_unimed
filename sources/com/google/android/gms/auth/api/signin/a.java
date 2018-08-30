package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public class a implements Creator<GoogleSignInAccount> {
    /* renamed from: a */
    public GoogleSignInAccount createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 9:
                    str6 = SafeParcelReader.o(parcel, a);
                    break;
                case 10:
                    list = SafeParcelReader.c(parcel, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.o(parcel, a);
                    break;
                case 12:
                    str8 = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
    }

    /* renamed from: a */
    public GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
