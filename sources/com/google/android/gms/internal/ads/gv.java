package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
public final class gv {
    private final long a;
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();
    private final Map<String, aui> d = new HashMap();
    private String e;
    private String f;
    private boolean g = false;

    public gv(String str, long j) {
        int i = 0;
        this.f = str;
        this.a = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("status", -1) != 1) {
                    this.g = false;
                    kk.e("App settings could not be fetched successfully.");
                    return;
                }
                this.g = true;
                this.e = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString("format");
                        CharSequence optString2 = jSONObject2.optString("ad_unit_id");
                        if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2))) {
                            if (AdType.INTERSTITIAL.equalsIgnoreCase(optString)) {
                                this.c.add(optString2);
                            } else if ("rewarded".equalsIgnoreCase(optString)) {
                                jSONObject2 = jSONObject2.optJSONObject("mediation_config");
                                if (jSONObject2 != null) {
                                    this.d.put(optString2, new aui(jSONObject2));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    while (i < optJSONArray2.length()) {
                        this.b.add(optJSONArray2.optString(i));
                        i++;
                    }
                }
            } catch (Throwable e) {
                kk.c("Exception occurred while processing app setting json", e);
                au.i().a(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long a() {
        return this.a;
    }

    public final boolean b() {
        return this.g;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final Map<String, aui> e() {
        return this.d;
    }
}
