package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
public final class q {
    private final s a;
    private final Clock b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private final Map<Class<? extends r>, r> j;
    private final List<zzo> k;

    private q(q qVar) {
        this.a = qVar.a;
        this.b = qVar.b;
        this.d = qVar.d;
        this.e = qVar.e;
        this.f = qVar.f;
        this.g = qVar.g;
        this.h = qVar.h;
        this.k = new ArrayList(qVar.k);
        this.j = new HashMap(qVar.j.size());
        for (Entry entry : qVar.j.entrySet()) {
            r c = c((Class) entry.getKey());
            ((r) entry.getValue()).a(c);
            this.j.put((Class) entry.getKey(), c);
        }
    }

    @VisibleForTesting
    q(s sVar, Clock clock) {
        ar.a((Object) sVar);
        ar.a((Object) clock);
        this.a = sVar;
        this.b = clock;
        this.g = 1800000;
        this.h = 3024000000L;
        this.j = new HashMap();
        this.k = new ArrayList();
    }

    @TargetApi(19)
    private static <T extends r> T c(Class<T> cls) {
        try {
            return (r) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            } else if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            } else if (VERSION.SDK_INT < 19 || !(e instanceof ReflectiveOperationException)) {
                throw new RuntimeException(e);
            } else {
                throw new IllegalArgumentException("Linkage exception", e);
            }
        }
    }

    @VisibleForTesting
    public final q a() {
        return new q(this);
    }

    @VisibleForTesting
    public final <T extends r> T a(Class<T> cls) {
        return (r) this.j.get(cls);
    }

    @VisibleForTesting
    public final void a(long j) {
        this.e = j;
    }

    @VisibleForTesting
    public final void a(r rVar) {
        ar.a((Object) rVar);
        Class cls = rVar.getClass();
        if (cls.getSuperclass() != r.class) {
            throw new IllegalArgumentException();
        }
        rVar.a(b(cls));
    }

    @VisibleForTesting
    public final <T extends r> T b(Class<T> cls) {
        r rVar = (r) this.j.get(cls);
        if (rVar != null) {
            return rVar;
        }
        T c = c(cls);
        this.j.put(cls, c);
        return c;
    }

    @VisibleForTesting
    public final Collection<r> b() {
        return this.j.values();
    }

    public final List<zzo> c() {
        return this.k;
    }

    @VisibleForTesting
    public final long d() {
        return this.d;
    }

    @VisibleForTesting
    public final void e() {
        this.a.i().a(this);
    }

    @VisibleForTesting
    public final boolean f() {
        return this.c;
    }

    @VisibleForTesting
    final void g() {
        this.f = this.b.elapsedRealtime();
        if (this.e != 0) {
            this.d = this.e;
        } else {
            this.d = this.b.currentTimeMillis();
        }
        this.c = true;
    }

    final s h() {
        return this.a;
    }

    @VisibleForTesting
    final boolean i() {
        return this.i;
    }

    @VisibleForTesting
    final void j() {
        this.i = true;
    }
}
