package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import org.json.JSONObject;

@zzadh
public final class en implements zzafr {
    private zzwf<JSONObject, JSONObject> a;
    private zzwf<JSONObject, JSONObject> b;

    public en(Context context) {
        this.a = au.s().a(context, zzang.a()).a("google.afma.request.getAdDictionary", atw.a, atw.a);
        this.b = au.s().a(context, zzang.a()).a("google.afma.sdkConstants.getSdkConstants", atw.a, atw.a);
    }

    public final zzwf<JSONObject, JSONObject> zzof() {
        return this.a;
    }

    public final zzwf<JSONObject, JSONObject> zzog() {
        return this.b;
    }
}
