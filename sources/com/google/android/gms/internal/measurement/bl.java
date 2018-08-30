package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class bl<V> {
    private final V a;
    private final GservicesValue<V> b;

    private bl(GservicesValue<V> gservicesValue, V v) {
        ar.a((Object) gservicesValue);
        this.b = gservicesValue;
        this.a = v;
    }

    static bl<Float> a(String str, float f, float f2) {
        return new bl(GservicesValue.a(str, Float.valueOf(0.5f)), Float.valueOf(0.5f));
    }

    static bl<Integer> a(String str, int i, int i2) {
        return new bl(GservicesValue.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static bl<Long> a(String str, long j, long j2) {
        return new bl(GservicesValue.a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static bl<String> a(String str, String str2, String str3) {
        return new bl(GservicesValue.a(str, str3), str2);
    }

    static bl<Boolean> a(String str, boolean z, boolean z2) {
        return new bl(GservicesValue.a(str, z2), Boolean.valueOf(z));
    }

    public final V a() {
        return this.a;
    }
}
