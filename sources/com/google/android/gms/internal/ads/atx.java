package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import org.json.JSONObject;

final /* synthetic */ class atx implements zzwh {
    static final zzwh a = new atx();

    private atx() {
    }

    public final Object zze(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(atw.b));
    }
}
