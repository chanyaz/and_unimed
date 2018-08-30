package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.r;
import java.util.HashMap;
import java.util.Map;

public final class w extends r<w> {
    public String a;
    public long b;
    public String c;
    public String d;

    public final /* synthetic */ void a(r rVar) {
        w wVar = (w) rVar;
        if (!TextUtils.isEmpty(this.a)) {
            wVar.a = this.a;
        }
        if (this.b != 0) {
            wVar.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            wVar.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            wVar.d = this.d;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.a);
        hashMap.put("timeInMillis", Long.valueOf(this.b));
        hashMap.put("category", this.c);
        hashMap.put("label", this.d);
        return r.a((Object) hashMap);
    }
}
