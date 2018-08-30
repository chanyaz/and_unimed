package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class s implements Creator<zzal> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        PendingIntent pendingIntent = null;
        List list = null;
        String str = "";
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    list = SafeParcelReader.B(parcel, a);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzal(list, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzal[i];
    }
}
