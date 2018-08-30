package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.ad;
import com.google.common.base.c;
import com.google.common.base.o;
import com.google.common.base.p;
import com.google.common.base.s;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
public final class MapMaker extends ch<Object, Object> {
    boolean b;
    int c = -1;
    int d = -1;
    int e = -1;
    fv f;
    fv g;
    long h = -1;
    long i = -1;
    ff j;
    Equivalence<Object> k;
    ad l;

    interface RemovalListener<K, V> {
        void onRemoval(fg<K, V> fgVar);
    }

    private void c(long j, TimeUnit timeUnit) {
        s.b(this.h == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.h));
        s.b(this.i == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(this.i));
        s.a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
    }

    public MapMaker a(int i) {
        boolean z = true;
        s.b(this.c == -1, "initial capacity was already set to %s", Integer.valueOf(this.c));
        if (i < 0) {
            z = false;
        }
        s.a(z);
        this.c = i;
        return this;
    }

    @Deprecated
    MapMaker a(long j, TimeUnit timeUnit) {
        c(j, timeUnit);
        this.h = timeUnit.toNanos(j);
        if (j == 0 && this.j == null) {
            this.j = ff.EXPIRED;
        }
        this.b = true;
        return this;
    }

    @GwtIncompatible("To be supported")
    MapMaker a(Equivalence<Object> equivalence) {
        s.b(this.k == null, "key equivalence was already set to %s", this.k);
        this.k = (Equivalence) s.a((Object) equivalence);
        this.b = true;
        return this;
    }

    MapMaker a(fv fvVar) {
        boolean z = false;
        s.b(this.f == null, "Key strength was already set to %s", this.f);
        this.f = (fv) s.a((Object) fvVar);
        if (this.f != fv.SOFT) {
            z = true;
        }
        s.a(z, (Object) "Soft keys are not supported");
        if (fvVar != fv.STRONG) {
            this.b = true;
        }
        return this;
    }

    @GwtIncompatible("To be supported")
    @Deprecated
    <K, V> ch<K, V> a(RemovalListener<K, V> removalListener) {
        s.b(this.a == null);
        this.a = (RemovalListener) s.a((Object) removalListener);
        this.b = true;
        return this;
    }

    Equivalence<Object> b() {
        return (Equivalence) o.b(this.k, f().a());
    }

    @Deprecated
    MapMaker b(int i) {
        boolean z = false;
        s.b(this.e == -1, "maximum size was already set to %s", Integer.valueOf(this.e));
        if (i >= 0) {
            z = true;
        }
        s.a(z, (Object) "maximum size must not be negative");
        this.e = i;
        this.b = true;
        if (this.e == 0) {
            this.j = ff.SIZE;
        }
        return this;
    }

    @GwtIncompatible("To be supported")
    @Deprecated
    MapMaker b(long j, TimeUnit timeUnit) {
        c(j, timeUnit);
        this.i = timeUnit.toNanos(j);
        if (j == 0 && this.j == null) {
            this.j = ff.EXPIRED;
        }
        this.b = true;
        return this;
    }

    MapMaker b(fv fvVar) {
        s.b(this.g == null, "Value strength was already set to %s", this.g);
        this.g = (fv) s.a((Object) fvVar);
        if (fvVar != fv.STRONG) {
            this.b = true;
        }
        return this;
    }

    int c() {
        return this.c == -1 ? 16 : this.c;
    }

    public MapMaker c(int i) {
        boolean z = true;
        s.b(this.d == -1, "concurrency level was already set to %s", Integer.valueOf(this.d));
        if (i <= 0) {
            z = false;
        }
        s.a(z);
        this.d = i;
        return this;
    }

    int d() {
        return this.d == -1 ? 4 : this.d;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public MapMaker e() {
        return a(fv.WEAK);
    }

    fv f() {
        return (fv) o.b(this.f, fv.STRONG);
    }

    fv g() {
        return (fv) o.b(this.g, fv.STRONG);
    }

    long h() {
        return this.h == -1 ? 0 : this.h;
    }

    long i() {
        return this.i == -1 ? 0 : this.i;
    }

    ad j() {
        return (ad) o.b(this.l, ad.b());
    }

    public <K, V> ConcurrentMap<K, V> k() {
        if (!this.b) {
            return new ConcurrentHashMap(c(), 0.75f, d());
        }
        return this.j == null ? new MapMakerInternalMap(this) : new fe(this);
    }

    public String toString() {
        p a = o.a((Object) this);
        if (this.c != -1) {
            a.a("initialCapacity", this.c);
        }
        if (this.d != -1) {
            a.a("concurrencyLevel", this.d);
        }
        if (this.e != -1) {
            a.a("maximumSize", this.e);
        }
        if (this.h != -1) {
            a.a("expireAfterWrite", this.h + "ns");
        }
        if (this.i != -1) {
            a.a("expireAfterAccess", this.i + "ns");
        }
        if (this.f != null) {
            a.a("keyStrength", c.a(this.f.toString()));
        }
        if (this.g != null) {
            a.a("valueStrength", c.a(this.g.toString()));
        }
        if (this.k != null) {
            a.a("keyEquivalence");
        }
        if (this.a != null) {
            a.a("removalListener");
        }
        return a.toString();
    }
}
