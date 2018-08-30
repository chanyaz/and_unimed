package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class cs implements Creator<zzaej> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        zzaev zzaev = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        zzaig zzaig = null;
        List list4 = null;
        List list5 = null;
        boolean z10 = false;
        zzael zzael = null;
        boolean z11 = false;
        String str9 = null;
        List list6 = null;
        boolean z12 = false;
        String str10 = null;
        zzaiq zzaiq = null;
        String str11 = null;
        boolean z13 = false;
        boolean z14 = false;
        Bundle bundle = null;
        boolean z15 = false;
        int i4 = 0;
        boolean z16 = false;
        List list7 = null;
        boolean z17 = false;
        String str12 = null;
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
                    list = SafeParcelReader.B(parcel, a);
                    break;
                case 5:
                    i2 = SafeParcelReader.e(parcel, a);
                    break;
                case 6:
                    list2 = SafeParcelReader.B(parcel, a);
                    break;
                case 7:
                    j = SafeParcelReader.g(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    j2 = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    list3 = SafeParcelReader.B(parcel, a);
                    break;
                case 11:
                    j3 = SafeParcelReader.g(parcel, a);
                    break;
                case 12:
                    i3 = SafeParcelReader.e(parcel, a);
                    break;
                case 13:
                    str3 = SafeParcelReader.o(parcel, a);
                    break;
                case 14:
                    j4 = SafeParcelReader.g(parcel, a);
                    break;
                case 15:
                    str4 = SafeParcelReader.o(parcel, a);
                    break;
                case 18:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 19:
                    str5 = SafeParcelReader.o(parcel, a);
                    break;
                case 21:
                    str6 = SafeParcelReader.o(parcel, a);
                    break;
                case 22:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 23:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 24:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                case 25:
                    z6 = SafeParcelReader.c(parcel, a);
                    break;
                case 26:
                    z7 = SafeParcelReader.c(parcel, a);
                    break;
                case 28:
                    zzaev = (zzaev) SafeParcelReader.a(parcel, a, zzaev.CREATOR);
                    break;
                case 29:
                    str7 = SafeParcelReader.o(parcel, a);
                    break;
                case 30:
                    str8 = SafeParcelReader.o(parcel, a);
                    break;
                case 31:
                    z8 = SafeParcelReader.c(parcel, a);
                    break;
                case 32:
                    z9 = SafeParcelReader.c(parcel, a);
                    break;
                case 33:
                    zzaig = (zzaig) SafeParcelReader.a(parcel, a, zzaig.CREATOR);
                    break;
                case 34:
                    list4 = SafeParcelReader.B(parcel, a);
                    break;
                case 35:
                    list5 = SafeParcelReader.B(parcel, a);
                    break;
                case 36:
                    z10 = SafeParcelReader.c(parcel, a);
                    break;
                case 37:
                    zzael = (zzael) SafeParcelReader.a(parcel, a, zzael.CREATOR);
                    break;
                case 38:
                    z11 = SafeParcelReader.c(parcel, a);
                    break;
                case 39:
                    str9 = SafeParcelReader.o(parcel, a);
                    break;
                case 40:
                    list6 = SafeParcelReader.B(parcel, a);
                    break;
                case 42:
                    z12 = SafeParcelReader.c(parcel, a);
                    break;
                case 43:
                    str10 = SafeParcelReader.o(parcel, a);
                    break;
                case 44:
                    zzaiq = (zzaiq) SafeParcelReader.a(parcel, a, zzaiq.CREATOR);
                    break;
                case 45:
                    str11 = SafeParcelReader.o(parcel, a);
                    break;
                case 46:
                    z13 = SafeParcelReader.c(parcel, a);
                    break;
                case 47:
                    z14 = SafeParcelReader.c(parcel, a);
                    break;
                case 48:
                    bundle = SafeParcelReader.q(parcel, a);
                    break;
                case 49:
                    z15 = SafeParcelReader.c(parcel, a);
                    break;
                case 50:
                    i4 = SafeParcelReader.e(parcel, a);
                    break;
                case 51:
                    z16 = SafeParcelReader.c(parcel, a);
                    break;
                case 52:
                    list7 = SafeParcelReader.B(parcel, a);
                    break;
                case 53:
                    z17 = SafeParcelReader.c(parcel, a);
                    break;
                case 54:
                    str12 = SafeParcelReader.o(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.E(parcel, b);
        return new zzaej(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzaev, str7, str8, z8, z9, zzaig, list4, list5, z10, zzael, z11, str9, list6, z12, str10, zzaiq, str11, z13, z14, bundle, z15, i4, z16, list7, z17, str12);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaej[i];
    }
}
