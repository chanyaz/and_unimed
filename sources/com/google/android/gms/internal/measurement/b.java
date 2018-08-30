package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.analytics.r;
import java.util.HashMap;
import java.util.Map;

public final class b extends r<b> {
    private String a;
    private String b;
    private String c;
    private long d;

    public final String a() {
        return this.a;
    }

    public final /* synthetic */ void a(r rVar) {
        b bVar = (b) rVar;
        if (!TextUtils.isEmpty(this.a)) {
            bVar.a = this.a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            bVar.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            bVar.c = this.c;
        }
        if (this.d != 0) {
            bVar.d = this.d;
        }
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.a);
        hashMap.put(c.jD, this.b);
        hashMap.put("label", this.c);
        hashMap.put("value", Long.valueOf(this.d));
        return r.a((Object) hashMap);
    }
}
