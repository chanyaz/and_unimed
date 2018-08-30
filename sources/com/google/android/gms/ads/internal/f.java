package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.kq;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzanz;
import org.json.JSONObject;

final /* synthetic */ class f implements zzanj {
    static final zzanj a = new f();

    private f() {
    }

    public final zzanz zzc(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            au.i().l().f(jSONObject.getString("appSettingsJson"));
        }
        return kq.a(null);
    }
}
