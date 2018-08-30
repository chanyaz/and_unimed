package com.google.common.collect;

import com.google.common.base.s;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

final class gq<K, V> extends gl<K, Collection<V>> {
    private final Multimap<K, V> a;

    gq(Multimap<K, V> multimap) {
        this.a = (Multimap) s.a((Object) multimap);
    }

    protected Set<Entry<K, Collection<V>>> a() {
        return new gr(this);
    }

    void a(Object obj) {
        this.a.keySet().remove(obj);
    }

    /* renamed from: b */
    public Collection<V> get(Object obj) {
        return containsKey(obj) ? this.a.get(obj) : null;
    }

    /* renamed from: c */
    public Collection<V> remove(Object obj) {
        return containsKey(obj) ? this.a.removeAll(obj) : null;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Set<K> keySet() {
        return this.a.keySet();
    }

    public int size() {
        return this.a.keySet().size();
    }
}
