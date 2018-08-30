package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.analytics.r;
import java.util.HashMap;
import java.util.Map;

public final class v extends r<v> {
    public String a;
    public String b;
    public String c;

    public final /* synthetic */ void a(r rVar) {
        v vVar = (v) rVar;
        if (!TextUtils.isEmpty(this.a)) {
            vVar.a = this.a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            vVar.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            vVar.c = this.c;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.a);
        hashMap.put(c.jD, this.b);
        hashMap.put("target", this.c);
        return r.a((Object) hashMap);
    }
}
