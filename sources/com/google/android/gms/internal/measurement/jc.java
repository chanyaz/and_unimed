package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.r;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public final class jc extends r<jc> {
    private String a;
    private String b;
    private String c;
    private String d;

    public final String a() {
        return this.a;
    }

    public final void a(jc jcVar) {
        if (!TextUtils.isEmpty(this.a)) {
            jcVar.a = this.a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            jcVar.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            jcVar.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            jcVar.d = this.d;
        }
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
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

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.a);
        hashMap.put("appVersion", this.b);
        hashMap.put("appId", this.c);
        hashMap.put("appInstallerId", this.d);
        return r.a((Object) hashMap);
    }
}
