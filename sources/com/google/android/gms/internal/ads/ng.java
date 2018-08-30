package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class ng implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ nd e;

    ng(nd ndVar, String str, String str2, String str3, String str4) {
        this.e = ndVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.a);
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("cachedSrc", this.b);
        }
        hashMap.put("type", nd.b(this.c));
        hashMap.put("reason", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            hashMap.put("message", this.d);
        }
        this.e.a("onPrecacheEvent", hashMap);
    }
}
