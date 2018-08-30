package com.google.common.collect;

import com.google.common.collect.j$com.google.common.collect.k;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class s extends k implements SortedMap<K, Collection<V>> {
    SortedSet<K> d;
    final /* synthetic */ j e;

    s(j jVar, SortedMap<K, Collection<V>> sortedMap) {
        this.e = jVar;
        super(jVar, sortedMap);
    }

    public Comparator<? super K> comparator() {
        return g().comparator();
    }

    /* renamed from: e */
    SortedSet<K> h() {
        return new t(this.e, g());
    }

    /* renamed from: f */
    public SortedSet<K> keySet() {
        SortedSet<K> sortedSet = this.d;
        if (sortedSet != null) {
            return sortedSet;
        }
        sortedSet = h();
        this.d = sortedSet;
        return sortedSet;
    }

    public K firstKey() {
        return g().firstKey();
    }

    SortedMap<K, Collection<V>> g() {
        return (SortedMap) this.a;
    }

    public SortedMap<K, Collection<V>> headMap(K k) {
        return new s(this.e, g().headMap(k));
    }

    public K lastKey() {
        return g().lastKey();
    }

    public SortedMap<K, Collection<V>> subMap(K k, K k2) {
        return new s(this.e, g().subMap(k, k2));
    }

    public SortedMap<K, Collection<V>> tailMap(K k) {
        return new s(this.e, g().tailMap(k));
    }
}
