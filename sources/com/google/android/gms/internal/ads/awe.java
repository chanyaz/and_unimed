package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.mediation.g;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@zzadh
public final class awe {
    public static int a(ErrorCode errorCode) {
        switch (awf.a[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static g a(zzjj zzjj, boolean z) {
        Gender gender;
        Set hashSet = zzjj.e != null ? new HashSet(zzjj.e) : null;
        Date date = new Date(zzjj.b);
        switch (zzjj.d) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            default:
                gender = Gender.UNKNOWN;
                break;
        }
        return new g(date, gender, hashSet, z, zzjj.k);
    }
}
