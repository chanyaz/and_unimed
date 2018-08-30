package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public class b implements Creator<ConnectionResult> {
    /* renamed from: a */
    public ConnectionResult createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        String str = null;
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
                    pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, a, PendingIntent.CREATOR);
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
        return new ConnectionResult(i2, i, pendingIntent, str);
    }

    /* renamed from: a */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
