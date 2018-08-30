package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class anl implements zzv<Object> {
    private final /* synthetic */ ank a;

    anl(ank ank) {
        this.a = ank;
    }

    public final void zza(Object obj, Map<String, String> map) {
        try {
            this.a.b = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException e) {
            kk.c("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.a.a = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (this.a.e == null) {
            kk.b("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            this.a.e.onUnconfirmedClickReceived(str);
        } catch (Throwable e2) {
            kk.d("#007 Could not call remote method.", e2);
        }
    }
}
