package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.bk;
import java.util.Arrays;

@zzadh
final class arv {
    private final Object[] a;

    arv(zzjj zzjj, String str, int i) {
        this.a = bk.a((String) akc.f().a(amn.aV), zzjj, str, i, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof arv)) {
            return false;
        }
        return Arrays.equals(this.a, ((arv) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.a);
        return new StringBuilder(String.valueOf(arrays).length() + 24).append("[InterstitialAdPoolKey ").append(arrays).append("]").toString();
    }
}
