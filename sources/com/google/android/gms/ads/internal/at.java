package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzjj;
import java.util.Map;
import java.util.TreeMap;

final class at {
    private final String a;
    private final Map<String, String> b = new TreeMap();
    private String c;
    private String d;

    public at(String str) {
        this.a = str;
    }

    public final String a() {
        return this.d;
    }

    public final void a(zzjj zzjj, zzang zzang) {
        this.c = zzjj.j.a;
        Bundle bundle = zzjj.m != null ? zzjj.m.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle != null) {
            String str = (String) akc.f().a(amn.cy);
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.d = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.b.put(str2.substring(4), bundle.getString(str2));
                }
            }
            this.b.put("SDKVersion", zzang.a);
        }
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public final Map<String, String> d() {
        return this.b;
    }
}
