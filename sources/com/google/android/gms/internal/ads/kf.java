package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class kf implements zzand {
    private final String a;
    private final String b;
    private final Map c;
    private final byte[] d;

    kf(String str, String str2, Map map, byte[] bArr) {
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = bArr;
    }

    public final void zza(JsonWriter jsonWriter) {
        ke.a(this.a, this.b, this.c, this.d, jsonWriter);
    }
}
