package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class dh<V> {
    private final jj<V> a;
    private final String b;

    private dh(String str, jj<V> jjVar) {
        ar.a((Object) jjVar);
        this.a = jjVar;
        this.b = str;
    }

    static dh<Double> a(String str, double d, double d2) {
        return new dh(str, dg.V.a(str, -3.0d));
    }

    static dh<Integer> a(String str, int i, int i2) {
        return new dh(str, dg.V.a(str, i));
    }

    static dh<Long> a(String str, long j, long j2) {
        return new dh(str, dg.V.a(str, j));
    }

    static dh<String> a(String str, String str2, String str3) {
        return new dh(str, dg.V.a(str, str2));
    }

    static dh<Boolean> a(String str, boolean z, boolean z2) {
        return new dh(str, dg.V.a(str, z));
    }

    public final V a(V v) {
        return v != null ? v : this.a.a();
    }

    public final String a() {
        return this.b;
    }

    public final V b() {
        return this.a.a();
    }
}
