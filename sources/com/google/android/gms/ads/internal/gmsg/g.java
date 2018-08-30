package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.internal.ads.zzadh;
import java.util.Map;

@zzadh
public final class g implements zzv<Object> {
    private final Context a;

    public g(Context context) {
        this.a = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (au.B().a(this.a)) {
            au.B().a(this.a, (String) map.get("eventName"), (String) map.get("eventId"));
        }
    }
}
