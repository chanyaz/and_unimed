package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import org.json.JSONObject;

@zzadh
public final class gs {
    public final zzaef a;
    public final zzaej b;
    public final aui c;
    @Nullable
    public final zzjn d;
    public final int e;
    public final long f;
    public final long g;
    @Nullable
    public final JSONObject h;
    public final ahx i;
    public final boolean j;

    public gs(zzaef zzaef, zzaej zzaej, aui aui, zzjn zzjn, int i, long j, long j2, JSONObject jSONObject, ahx ahx, @Nullable Boolean bool) {
        this.a = zzaef;
        this.b = zzaej;
        this.c = aui;
        this.d = zzjn;
        this.e = i;
        this.f = j;
        this.g = j2;
        this.h = jSONObject;
        this.i = ahx;
        if (bool != null) {
            this.j = bool.booleanValue();
        } else if (jt.a(zzaef.c)) {
            this.j = true;
        } else {
            this.j = false;
        }
    }

    public gs(zzaef zzaef, zzaej zzaej, aui aui, zzjn zzjn, int i, long j, long j2, JSONObject jSONObject, aib aib) {
        this.a = zzaef;
        this.b = zzaej;
        this.c = null;
        this.d = null;
        this.e = i;
        this.f = j;
        this.g = j2;
        this.h = null;
        this.i = new ahx(aib);
        this.j = false;
    }
}
