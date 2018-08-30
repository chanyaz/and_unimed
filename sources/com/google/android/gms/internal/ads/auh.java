package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class auh {
    public final String a;
    public final String b;
    public final List<String> c;
    public final String d;
    public final String e;
    public final List<String> f;
    public final List<String> g;
    public final List<String> h;
    public final List<String> i;
    public final List<String> j;
    public final String k;
    public final List<String> l;
    public final List<String> m;
    public final List<String> n;
    @Nullable
    public final String o;
    @Nullable
    public final String p;
    public final String q;
    @Nullable
    public final List<String> r;
    public final String s;
    public final long t;
    @Nullable
    private final String u;

    public auh(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, List<String> list4, List<String> list5, String str5, String str6, List<String> list6, List<String> list7, List<String> list8, String str7, String str8, String str9, List<String> list9, String str10, List<String> list10, String str11, long j) {
        this.a = str;
        this.b = null;
        this.c = list;
        this.d = null;
        this.e = null;
        this.f = list2;
        this.g = list3;
        this.h = list4;
        this.i = list5;
        this.k = str5;
        this.l = list6;
        this.m = list7;
        this.n = list8;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.j = list10;
        this.u = null;
        this.t = -1;
    }

    public auh(JSONObject jSONObject) {
        List a;
        this.b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.c = Collections.unmodifiableList(arrayList);
        this.d = jSONObject.optString("allocation_id", null);
        au.x();
        this.f = aup.a(jSONObject, "clickurl");
        au.x();
        this.g = aup.a(jSONObject, "imp_urls");
        au.x();
        this.h = aup.a(jSONObject, "downloaded_imp_urls");
        au.x();
        this.j = aup.a(jSONObject, "fill_urls");
        au.x();
        this.l = aup.a(jSONObject, "video_start_urls");
        au.x();
        this.n = aup.a(jSONObject, "video_complete_urls");
        au.x();
        this.m = ((Boolean) akc.f().a(amn.ax)).booleanValue() ? aup.a(jSONObject, "video_reward_urls") : this.n;
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            au.x();
            a = aup.a(optJSONObject, "manual_impression_urls");
        } else {
            a = null;
        }
        this.i = a;
        this.a = optJSONObject != null ? optJSONObject.toString() : null;
        optJSONObject = jSONObject.optJSONObject("data");
        this.k = optJSONObject != null ? optJSONObject.toString() : null;
        this.e = optJSONObject != null ? optJSONObject.optString("class_name") : null;
        this.o = jSONObject.optString("html_template", null);
        this.p = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("assets");
        this.q = optJSONObject2 != null ? optJSONObject2.toString() : null;
        au.x();
        this.r = aup.a(jSONObject, "template_ids");
        optJSONObject2 = jSONObject.optJSONObject("ad_loader_options");
        this.s = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.u = jSONObject.optString("response_type", null);
        this.t = jSONObject.optLong("ad_network_timeout_millis", -1);
    }

    public final boolean a() {
        return "banner".equalsIgnoreCase(this.u);
    }

    public final boolean b() {
        return "native".equalsIgnoreCase(this.u);
    }
}
