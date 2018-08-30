package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public class e implements Creator<WakeLockEvent> {
    /* renamed from: a */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 6:
                    list = SafeParcelReader.B(parcel, a);
                    break;
                case 8:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 11:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 12:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 13:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 14:
                    i4 = SafeParcelReader.e(parcel, a);
                    break;
                case 15:
                    f = SafeParcelReader.j(parcel, a);
                    break;
                case 16:
                    j3 = SafeParcelReader.g(parcel, a);
                    break;
                case 17:
                    str5 = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
    }

    /* renamed from: a */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
