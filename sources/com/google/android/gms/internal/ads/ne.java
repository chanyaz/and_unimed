package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class ne implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ boolean e = false;
    private final /* synthetic */ nd f;

    ne(nd ndVar, String str, String str2, int i, int i2, boolean z) {
        this.f = ndVar;
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bytesLoaded", Integer.toString(this.c));
        hashMap.put("totalBytes", Integer.toString(this.d));
        hashMap.put("cacheReady", this.e ? "1" : "0");
        this.f.a("onPrecacheEvent", hashMap);
    }
}
