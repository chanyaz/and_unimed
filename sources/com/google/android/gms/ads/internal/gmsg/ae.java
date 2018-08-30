package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzue;
import java.util.Map;
import org.json.JSONObject;

final class ae implements Runnable {
    final /* synthetic */ zzue a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ HttpClient c;

    ae(HttpClient httpClient, Map map, zzue zzue) {
        this.c = httpClient;
        this.b = map;
        this.a = zzue;
    }

    public final void run() {
        kk.b("Received Http request.");
        try {
            JSONObject send = this.c.send(new JSONObject((String) this.b.get("http_request")));
            if (send == null) {
                kk.c("Response should not be null.");
            } else {
                ht.a.post(new af(this, send));
            }
        } catch (Throwable e) {
            kk.b("Error converting request to json.", e);
        }
    }
}
