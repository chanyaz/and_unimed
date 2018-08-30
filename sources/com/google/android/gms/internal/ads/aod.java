package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final /* synthetic */ class aod implements zzasd {
    private final aoc a;
    private final Map b;
    private final zzacm c;

    aod(aoc aoc, Map map, zzacm zzacm) {
        this.a = aoc;
        this.b = map;
        this.c = zzacm;
    }

    public final void zze(boolean z) {
        aoc aoc = this.a;
        Map map = this.b;
        zzacm zzacm = this.c;
        aoc.a.b = (String) map.get("id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            jSONObject.put("id", aoc.a.b);
            zzacm.zza("sendMessageToNativeJs", jSONObject);
        } catch (Throwable e) {
            kk.b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
