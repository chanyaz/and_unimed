package com.google.common.collect;

import com.google.common.collect.j$com.google.common.collect.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class t extends o implements SortedSet<K> {
    final /* synthetic */ j c;

    t(j jVar, SortedMap<K, Collection<V>> sortedMap) {
        this.c = jVar;
        super(jVar, sortedMap);
    }

    SortedMap<K, Collection<V>> b() {
        return (SortedMap) super.c();
    }

    public Comparator<? super K> comparator() {
        return b().comparator();
    }

    public K first() {
        return b().firstKey();
    }

    public SortedSet<K> headSet(K k) {
        return new t(this.c, b().headMap(k));
    }

    public K last() {
        return b().lastKey();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return new t(this.c, b().subMap(k, k2));
    }

    public SortedSet<K> tailSet(K k) {
        return new t(this.c, b().tailMap(k));
    }
}
