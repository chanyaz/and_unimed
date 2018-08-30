package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class nf implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ nd d;

    nf(nd ndVar, String str, String str2, int i) {
        this.d = ndVar;
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("totalBytes", Integer.toString(this.c));
        this.d.a("onPrecacheEvent", hashMap);
    }
}
