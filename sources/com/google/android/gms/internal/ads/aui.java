package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
public final class aui {
    public final List<auh> a;
    public final long b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final List<String> f;
    public final List<String> g;
    public final boolean h;
    public final String i;
    public final long j;
    public final String k;
    public final int l;
    public final int m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public int r;
    public int s;
    public boolean t;

    public aui(String str) {
        this(new JSONObject(str));
    }

    public aui(List<auh> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.a = list;
        this.b = j;
        this.c = list2;
        this.d = list3;
        this.e = list4;
        this.f = list5;
        this.g = list6;
        this.h = z;
        this.i = str;
        this.j = -1;
        this.r = 0;
        this.s = 1;
        this.k = null;
        this.l = 0;
        this.m = -1;
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = false;
    }

    public aui(JSONObject jSONObject) {
        String valueOf;
        if (kk.a(2)) {
            String str = "Mediation Response JSON: ";
            valueOf = String.valueOf(jSONObject.toString(2));
            hl.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            auh auh = new auh(jSONArray.getJSONObject(i2));
            if (auh.a()) {
                this.t = true;
            }
            arrayList.add(auh);
            if (i < 0) {
                boolean z;
                for (String valueOf2 : auh.c) {
                    if (valueOf2.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    i = i2;
                }
            }
        }
        this.r = i;
        this.s = jSONArray.length();
        this.a = Collections.unmodifiableList(arrayList);
        this.i = jSONObject.optString("qdata");
        this.m = jSONObject.optInt("fs_model_type", -1);
        this.n = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            au.x();
            this.c = aup.a(optJSONObject, "click_urls");
            au.x();
            this.d = aup.a(optJSONObject, "imp_urls");
            au.x();
            this.e = aup.a(optJSONObject, "downloaded_imp_urls");
            au.x();
            this.f = aup.a(optJSONObject, "nofill_urls");
            au.x();
            this.g = aup.a(optJSONObject, "remote_ping_urls");
            this.h = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.j = optLong > 0 ? optLong * 1000 : -1;
            zzaig a = zzaig.a(optJSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.k = null;
                this.l = 0;
            } else {
                this.k = a.a;
                this.l = a.b;
            }
            this.o = optJSONObject.optBoolean("use_displayed_impression", false);
            this.p = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.q = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            return;
        }
        this.b = -1;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = -1;
        this.k = null;
        this.l = 0;
        this.o = false;
        this.h = false;
        this.p = false;
        this.q = false;
    }
}
