package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.j$com.google.common.collect.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;

@GwtIncompatible("NavigableSet")
class q extends t implements NavigableSet<K> {
    final /* synthetic */ j b;

    q(j jVar, NavigableMap<K, Collection<V>> navigableMap) {
        this.b = jVar;
        super(jVar, navigableMap);
    }

    /* renamed from: a */
    NavigableMap<K, Collection<V>> b() {
        return (NavigableMap) super.b();
    }

    /* renamed from: a */
    public NavigableSet<K> headSet(K k) {
        return headSet(k, false);
    }

    /* renamed from: a */
    public NavigableSet<K> subSet(K k, K k2) {
        return subSet(k, true, k2, false);
    }

    /* renamed from: b */
    public NavigableSet<K> tailSet(K k) {
        return tailSet(k, true);
    }

    public K ceiling(K k) {
        return b().ceilingKey(k);
    }

    public Iterator<K> descendingIterator() {
        return descendingSet().iterator();
    }

    public NavigableSet<K> descendingSet() {
        return new q(this.b, b().descendingMap());
    }

    public K floor(K k) {
        return b().floorKey(k);
    }

    public NavigableSet<K> headSet(K k, boolean z) {
        return new q(this.b, b().headMap(k, z));
    }

    public K higher(K k) {
        return b().higherKey(k);
    }

    public K lower(K k) {
        return b().lowerKey(k);
    }

    public K pollFirst() {
        return er.f(iterator());
    }

    public K pollLast() {
        return er.f(descendingIterator());
    }

    public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
        return new q(this.b, b().subMap(k, z, k2, z2));
    }

    public NavigableSet<K> tailSet(K k, boolean z) {
        return new q(this.b, b().tailMap(k, z));
    }
}
