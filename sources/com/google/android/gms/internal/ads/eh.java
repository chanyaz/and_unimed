package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONObject;

@zzadh
public final class eh extends ej {
    private final Object a = new Object();
    private final Context b;
    @Nullable
    private SharedPreferences c;
    private final zzwf<JSONObject, JSONObject> d;

    public eh(Context context, zzwf<JSONObject, JSONObject> zzwf) {
        this.b = context.getApplicationContext();
        this.d = zzwf;
    }

    public final zzanz<Void> a() {
        synchronized (this.a) {
            if (this.c != null) {
            } else {
                this.c = this.b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (au.l().currentTimeMillis() - this.c.getLong("js_last_update", 0) < ((Long) akc.f().a(amn.bU)).longValue()) {
            return kq.a(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzang.a().a);
            jSONObject.put("mf", akc.f().a(amn.bV));
            jSONObject.put("cl", "193400285");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("dynamite_version", ModuleDescriptor.MODULE_VERSION);
            return kq.a(this.d.zzf(jSONObject), new ei(this), lf.b);
        } catch (Throwable e) {
            kk.b("Unable to populate SDK Core Constants parameters.", e);
            return kq.a(null);
        }
    }

    final /* synthetic */ Void a(JSONObject jSONObject) {
        amn.a(this.b, 1, jSONObject);
        this.c.edit().putLong("js_last_update", au.l().currentTimeMillis()).apply();
        return null;
    }
}
