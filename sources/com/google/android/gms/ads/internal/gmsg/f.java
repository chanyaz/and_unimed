package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.lk;
import com.google.android.gms.internal.ads.zzadh;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzadh
public final class f implements zzv<Object> {
    @VisibleForTesting
    private final HashMap<String, lk<JSONObject>> a = new HashMap();

    public final Future<JSONObject> a(String str) {
        Future lkVar = new lk();
        this.a.put(str, lkVar);
        return lkVar;
    }

    public final void b(String str) {
        lk lkVar = (lk) this.a.get(str);
        if (lkVar == null) {
            kk.c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!lkVar.isDone()) {
            lkVar.cancel(true);
        }
        this.a.remove(str);
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("request_id");
        String str2 = (String) map.get("fetched_ad");
        kk.b("Received ad from the cache.");
        lk lkVar = (lk) this.a.get(str);
        if (lkVar == null) {
            kk.c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            lkVar.b(new JSONObject(str2));
        } catch (Throwable e) {
            kk.b("Failed constructing JSON object from value passed from javascript", e);
            lkVar.b(null);
        } finally {
            this.a.remove(str);
        }
    }
}
