package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.a;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzadh
public final class ali {
    private final Date a;
    private final String b;
    private final int c;
    private final Set<String> d;
    private final Location e;
    private final boolean f;
    private final Bundle g;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> h;
    private final String i;
    private final String j;
    private final a k;
    private final int l;
    private final Set<String> m;
    private final Bundle n;
    private final Set<String> o;
    private final boolean p;

    public ali(alj alj) {
        this(alj, null);
    }

    public ali(alj alj, a aVar) {
        this.a = alj.g;
        this.b = alj.h;
        this.c = alj.i;
        this.d = Collections.unmodifiableSet(alj.a);
        this.e = alj.j;
        this.f = alj.k;
        this.g = alj.b;
        this.h = Collections.unmodifiableMap(alj.c);
        this.i = alj.l;
        this.j = alj.m;
        this.k = aVar;
        this.l = alj.n;
        this.m = Collections.unmodifiableSet(alj.d);
        this.n = alj.e;
        this.o = Collections.unmodifiableSet(alj.f);
        this.p = alj.o;
    }

    public final Bundle a(Class<? extends MediationAdapter> cls) {
        return this.g.getBundle(cls.getName());
    }

    public final Date a() {
        return this.a;
    }

    public final boolean a(Context context) {
        Set set = this.m;
        akc.a();
        return set.contains(kb.a(context));
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final Set<String> d() {
        return this.d;
    }

    public final Location e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }

    public final String g() {
        return this.i;
    }

    public final String h() {
        return this.j;
    }

    public final a i() {
        return this.k;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> j() {
        return this.h;
    }

    public final Bundle k() {
        return this.g;
    }

    public final int l() {
        return this.l;
    }

    public final Bundle m() {
        return this.n;
    }

    public final Set<String> n() {
        return this.o;
    }

    public final boolean o() {
        return this.p;
    }
}
