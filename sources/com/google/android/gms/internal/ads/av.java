package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class av implements Runnable {
    private final au a;
    private final JSONObject b;
    private final lk c;

    av(au auVar, JSONObject jSONObject, lk lkVar) {
        this.a = auVar;
        this.b = jSONObject;
        this.c = lkVar;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
