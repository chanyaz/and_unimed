package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;
import org.json.JSONObject;

final class aog implements zzv<Object> {
    private final /* synthetic */ zzacm a;
    private final /* synthetic */ aob b;

    aog(aob aob, zzacm zzacm) {
        this.b = aob;
        this.a = zzacm;
    }

    public final void zza(Object obj, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            jSONObject.put("id", this.b.b);
            this.a.zza("sendMessageToNativeJs", jSONObject);
        } catch (Throwable e) {
            kk.b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
