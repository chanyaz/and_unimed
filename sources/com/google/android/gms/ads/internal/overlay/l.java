package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzang;

public final class l implements Creator<AdOverlayInfoParcel> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        zzc zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        zzang zzang = null;
        String str4 = null;
        zzaq zzaq = null;
        IBinder iBinder6 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    zzc = (zzc) SafeParcelReader.a(parcel, a, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.p(parcel, a);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.p(parcel, a);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.p(parcel, a);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.p(parcel, a);
                    break;
                case 7:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.p(parcel, a);
                    break;
                case 11:
                    i = SafeParcelReader.e(parcel, a);
                    break;
                case 12:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 13:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 14:
                    zzang = (zzang) SafeParcelReader.a(parcel, a, zzang.CREATOR);
                    break;
                case 16:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 17:
                    zzaq = (zzaq) SafeParcelReader.a(parcel, a, zzaq.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.p(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new AdOverlayInfoParcel(zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzang, str4, zzaq, iBinder6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
