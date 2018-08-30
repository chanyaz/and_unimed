package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class gn<K, V> extends gm<K, V> implements SortedSet<K> {
    gn(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    /* renamed from: a */
    SortedMap<K, V> c() {
        return (SortedMap) super.c();
    }

    public Comparator<? super K> comparator() {
        return c().comparator();
    }

    public K first() {
        return c().firstKey();
    }

    public SortedSet<K> headSet(K k) {
        return new gn(c().headMap(k));
    }

    public K last() {
        return c().lastKey();
    }

    public SortedSet<K> subSet(K k, K k2) {
        return new gn(c().subMap(k, k2));
    }

    public SortedSet<K> tailSet(K k) {
        return new gn(c().tailMap(k));
    }
}
