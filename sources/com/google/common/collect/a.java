package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.o;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class a<K, V> extends bz<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0;
    transient a<V, K> a;
    private transient Map<K, V> b;
    private transient Set<K> c;
    private transient Set<V> d;
    private transient Set<Entry<K, V>> e;

    private a(Map<K, V> map, a<V, K> aVar) {
        this.b = map;
        this.a = aVar;
    }

    private V a(@Nullable K k, @Nullable V v, boolean z) {
        a((Object) k);
        b((Object) v);
        boolean containsKey = containsKey(k);
        if (containsKey && o.a(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            s.a(!containsValue(v), "value already present: %s", v);
        }
        V put = this.b.put(k, v);
        a(k, containsKey, put, v);
        return put;
    }

    private void a(K k, boolean z, V v, V v2) {
        if (z) {
            d(v);
        }
        this.a.b.put(v2, k);
    }

    private V c(Object obj) {
        V remove = this.b.remove(obj);
        d(remove);
        return remove;
    }

    private void d(V v) {
        this.a.b.remove(v);
    }

    K a(@Nullable K k) {
        return k;
    }

    /* renamed from: a */
    protected Map<K, V> b() {
        return this.b;
    }

    void a(a<V, K> aVar) {
        this.a = aVar;
    }

    void a(Map<K, V> map, Map<V, K> map2) {
        boolean z = true;
        s.b(this.b == null);
        s.b(this.a == null);
        s.a(map.isEmpty());
        s.a(map2.isEmpty());
        if (map == map2) {
            z = false;
        }
        s.a(z);
        this.b = map;
        this.a = new c(map2, this, null);
    }

    V b(@Nullable V v) {
        return v;
    }

    public void clear() {
        this.b.clear();
        this.a.b.clear();
    }

    public boolean containsValue(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.e;
        if (set != null) {
            return set;
        }
        set = new b(this, null);
        this.e = set;
        return set;
    }

    public V forcePut(@Nullable K k, @Nullable V v) {
        return a(k, v, true);
    }

    public BiMap<V, K> inverse() {
        return this.a;
    }

    public Set<K> keySet() {
        Set<K> set = this.c;
        if (set != null) {
            return set;
        }
        set = new d(this, null);
        this.c = set;
        return set;
    }

    public V put(@Nullable K k, @Nullable V v) {
        return a(k, v, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(@Nullable Object obj) {
        return containsKey(obj) ? c(obj) : null;
    }

    public Set<V> values() {
        Set<V> set = this.d;
        if (set != null) {
            return set;
        }
        set = new e(this, null);
        this.d = set;
        return set;
    }
}
