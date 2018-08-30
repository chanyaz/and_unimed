package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class k extends gl<K, Collection<V>> {
    final transient Map<K, Collection<V>> a;
    final /* synthetic */ j b;

    k(j jVar, Map<K, Collection<V>> map) {
        this.b = jVar;
        this.a = map;
    }

    /* renamed from: a */
    public Collection<V> get(Object obj) {
        Collection collection = (Collection) Maps.a(this.a, obj);
        return collection == null ? null : this.b.a(obj, collection);
    }

    Entry<K, Collection<V>> a(Entry<K, Collection<V>> entry) {
        Object key = entry.getKey();
        return Maps.a(key, this.b.a(key, (Collection) entry.getValue()));
    }

    protected Set<Entry<K, Collection<V>>> a() {
        return new l(this);
    }

    /* renamed from: b */
    public Collection<V> remove(Object obj) {
        Collection collection = (Collection) this.a.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection<V> c = this.b.c();
        c.addAll(collection);
        j.b(this.b, collection.size());
        collection.clear();
        return c;
    }

    public void clear() {
        if (this.a == this.b.a) {
            this.b.clear();
        } else {
            er.g(new m(this));
        }
    }

    public boolean containsKey(Object obj) {
        return Maps.b(this.a, obj);
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || this.a.equals(obj);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<K> keySet() {
        return this.b.keySet();
    }

    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }
}
