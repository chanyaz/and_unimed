package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class kh implements zzand {
    private final int a;
    private final Map b;

    kh(int i, Map map) {
        this.a = i;
        this.b = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        ke.a(this.a, this.b, jsonWriter);
    }
}
