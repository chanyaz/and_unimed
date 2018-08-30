package com.google.common.collect;

import com.google.common.base.s;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ix extends gl<C, V> {
    final R a;
    Map<C, V> b;
    final /* synthetic */ il c;

    ix(il ilVar, R r) {
        this.c = ilVar;
        this.a = s.a((Object) r);
    }

    protected Set<Entry<C, V>> a() {
        return new iy(this, null);
    }

    Map<C, V> b() {
        if (this.b != null && (!this.b.isEmpty() || !this.c.a.containsKey(this.a))) {
            return this.b;
        }
        Map<C, V> c = c();
        this.b = c;
        return c;
    }

    Map<C, V> c() {
        return (Map) this.c.a.get(this.a);
    }

    public void clear() {
        Map b = b();
        if (b != null) {
            b.clear();
        }
        d();
    }

    public boolean containsKey(Object obj) {
        Map b = b();
        return (obj == null || b == null || !Maps.b(b, obj)) ? false : true;
    }

    void d() {
        if (b() != null && this.b.isEmpty()) {
            this.c.a.remove(this.a);
            this.b = null;
        }
    }

    public V get(Object obj) {
        Map b = b();
        return (obj == null || b == null) ? null : Maps.a(b, obj);
    }

    public V put(C c, V v) {
        s.a((Object) c);
        s.a((Object) v);
        return (this.b == null || this.b.isEmpty()) ? this.c.put(this.a, c, v) : this.b.put(c, v);
    }

    public V remove(Object obj) {
        Map b = b();
        if (b == null) {
            return null;
        }
        V c = Maps.c(b, obj);
        d();
        return c;
    }
}
