package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.r;
import java.util.HashMap;
import java.util.Map;

public final class t extends r<t> {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private double h;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void b(boolean z) {
        this.g = true;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final String d() {
        return this.d;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final boolean e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final double h() {
        return this.h;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.a);
        hashMap.put("clientId", this.b);
        hashMap.put("userId", this.c);
        hashMap.put("androidAdId", this.d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.e));
        hashMap.put("sessionControl", this.f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.g));
        hashMap.put("sampleRate", Double.valueOf(this.h));
        return r.a((Object) hashMap);
    }
}
