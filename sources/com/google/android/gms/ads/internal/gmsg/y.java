package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.kk;
import java.util.Map;

final class y implements zzv<Object> {
    y() {
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = "Received log message: ";
        String valueOf = String.valueOf((String) map.get("string"));
        kk.d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
