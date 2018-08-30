package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.mopub.common.AdType;
import java.util.Map;
import org.json.JSONObject;

final class bl implements zzv<zzaqw> {
    private final /* synthetic */ zzaqw a;
    private final /* synthetic */ lk b;
    private final /* synthetic */ bf c;

    bl(bf bfVar, zzaqw zzaqw, lk lkVar) {
        this.c = bfVar;
        this.a = zzaqw;
        this.b = lkVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        try {
            JSONObject jSONObject;
            boolean z;
            String str = (String) map.get("success");
            String str2 = (String) map.get("failure");
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str);
                z = true;
            } else {
                z = false;
                jSONObject = new JSONObject(str2);
            }
            if (this.c.h.equals(jSONObject.optString("ads_id", ""))) {
                this.a.zzb("/nativeAdPreProcess", this);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", z);
                jSONObject2.put(AdType.STATIC_NATIVE, jSONObject);
                this.b.b(jSONObject2);
            }
        } catch (Throwable th) {
            kk.b("Error while preprocessing json.", th);
            this.b.a(th);
        }
    }
}
