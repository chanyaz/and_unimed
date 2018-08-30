package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

@zzadh
public abstract class amd<T> {
    private final int a;
    private final String b;
    private final T c;

    private amd(int i, String str, T t) {
        this.a = i;
        this.b = str;
        this.c = t;
        akc.e().a(this);
    }

    /* synthetic */ amd(int i, String str, Object obj, ame ame) {
        this(i, str, obj);
    }

    public static amd<String> a(int i, String str) {
        amd<String> a = a(i, str, null);
        akc.e().b(a);
        return a;
    }

    public static amd<Float> a(int i, String str, float f) {
        return new amh(i, str, Float.valueOf(f));
    }

    public static amd<Integer> a(int i, String str, int i2) {
        return new amf(i, str, Integer.valueOf(i2));
    }

    public static amd<Long> a(int i, String str, long j) {
        return new amg(i, str, Long.valueOf(j));
    }

    public static amd<Boolean> a(int i, String str, Boolean bool) {
        return new ame(i, str, bool);
    }

    public static amd<String> a(int i, String str, String str2) {
        return new ami(i, str, str2);
    }

    public static amd<String> b(int i, String str) {
        amd<String> a = a(i, str, null);
        akc.e().c(a);
        return a;
    }

    protected abstract T a(SharedPreferences sharedPreferences);

    protected abstract T a(JSONObject jSONObject);

    public final String a() {
        return this.b;
    }

    public abstract void a(Editor editor, T t);

    public final T b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }
}
