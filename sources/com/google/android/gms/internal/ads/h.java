package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@zzadh
public final class h {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private h(j jVar) {
        this.a = jVar.a;
        this.b = jVar.b;
        this.c = jVar.c;
        this.d = jVar.d;
        this.e = jVar.e;
    }

    /* synthetic */ h(j jVar, i iVar) {
        this(jVar);
    }

    public final JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        } catch (Throwable e) {
            kk.b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
