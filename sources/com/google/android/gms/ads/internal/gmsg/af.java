package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.kk;
import org.json.JSONObject;

final class af implements Runnable {
    private final /* synthetic */ JSONObject a;
    private final /* synthetic */ ae b;

    af(ae aeVar, JSONObject jSONObject) {
        this.b = aeVar;
        this.a = jSONObject;
    }

    public final void run() {
        this.b.a.zza("fetchHttpRequestCompleted", this.a);
        kk.b("Dispatched http response.");
    }
}
