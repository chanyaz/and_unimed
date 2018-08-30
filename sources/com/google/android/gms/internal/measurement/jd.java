package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.r;
import java.util.HashMap;
import java.util.Map;

public final class jd extends r<jd> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final String d() {
        return this.d;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final String e() {
        return this.e;
    }

    public final void e(String str) {
        this.e = str;
    }

    public final String f() {
        return this.f;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final String g() {
        return this.g;
    }

    public final void g(String str) {
        this.g = str;
    }

    public final String h() {
        return this.h;
    }

    public final void h(String str) {
        this.h = str;
    }

    public final String i() {
        return this.i;
    }

    public final void i(String str) {
        this.i = str;
    }

    public final String j() {
        return this.j;
    }

    public final void j(String str) {
        this.j = str;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.a);
        hashMap.put("source", this.b);
        hashMap.put("medium", this.c);
        hashMap.put("keyword", this.d);
        hashMap.put("content", this.e);
        hashMap.put("id", this.f);
        hashMap.put("adNetworkId", this.g);
        hashMap.put("gclid", this.h);
        hashMap.put("dclid", this.i);
        hashMap.put("aclid", this.j);
        return r.a((Object) hashMap);
    }
}
