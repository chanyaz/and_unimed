package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class ms {
    private final boolean a;
    private final int b;
    private final int c;
    private final int d;
    private final String e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;

    public ms(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
            }
        } else {
            jSONObject = null;
        }
        jSONObject2 = jSONObject;
        this.a = a(jSONObject2, "aggressive_media_codec_release", amn.B);
        this.b = b(jSONObject2, "byte_buffer_precache_limit", amn.m);
        this.c = b(jSONObject2, "exo_cache_buffer_size", amn.p);
        this.d = b(jSONObject2, "exo_connect_timeout_millis", amn.i);
        this.e = c(jSONObject2, "exo_player_version", amn.h);
        this.f = b(jSONObject2, "exo_read_timeout_millis", amn.j);
        this.g = b(jSONObject2, "load_check_interval_bytes", amn.k);
        this.h = b(jSONObject2, "player_precache_limit", amn.l);
        this.i = a(jSONObject2, "use_cache_data_source", amn.cH);
    }

    private static boolean a(JSONObject jSONObject, String str, amd<Boolean> amd) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException e) {
            }
        }
        return ((Boolean) akc.f().a((amd) amd)).booleanValue();
    }

    private static int b(JSONObject jSONObject, String str, amd<Integer> amd) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return ((Integer) akc.f().a((amd) amd)).intValue();
    }

    private static String c(JSONObject jSONObject, String str, amd<String> amd) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return (String) akc.f().a((amd) amd);
    }
}
