package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class db implements Creator<zzaey> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        String str2 = null;
        PackageInfo packageInfo = null;
        List list = null;
        String str3 = null;
        ApplicationInfo applicationInfo = null;
        zzang zzang = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 2:
                    zzang = (zzang) SafeParcelReader.a(parcel, a, zzang.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 5:
                    list = SafeParcelReader.B(parcel, a);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    str = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzaey(bundle, zzang, applicationInfo, str3, list, packageInfo, str2, z, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaey[i];
    }
}
