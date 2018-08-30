package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.r;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public final class jz extends r<jz> {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    private String f;

    public final String a() {
        return this.f;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.f);
        hashMap.put("screenColors", Integer.valueOf(this.a));
        hashMap.put("screenWidth", Integer.valueOf(this.b));
        hashMap.put("screenHeight", Integer.valueOf(this.c));
        hashMap.put("viewportWidth", Integer.valueOf(this.d));
        hashMap.put("viewportHeight", Integer.valueOf(this.e));
        return r.a((Object) hashMap);
    }
}
