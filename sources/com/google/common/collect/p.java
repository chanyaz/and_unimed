package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.j$com.google.common.collect.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;

@GwtIncompatible("NavigableAsMap")
class p extends s implements NavigableMap<K, Collection<V>> {
    final /* synthetic */ j c;

    p(j jVar, NavigableMap<K, Collection<V>> navigableMap) {
        this.c = jVar;
        super(jVar, navigableMap);
    }

    Entry<K, Collection<V>> a(Iterator<Entry<K, Collection<V>>> it) {
        if (!it.hasNext()) {
            return null;
        }
        Entry entry = (Entry) it.next();
        Collection c = this.c.c();
        c.addAll((Collection) entry.getValue());
        it.remove();
        return Maps.a(entry.getKey(), this.c.a(c));
    }

    /* renamed from: a */
    public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    /* renamed from: b */
    NavigableMap<K, Collection<V>> g() {
        return (NavigableMap) super.g();
    }

    /* renamed from: c */
    public NavigableMap<K, Collection<V>> headMap(K k) {
        return headMap(k, false);
    }

    /* renamed from: c */
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    public Entry<K, Collection<V>> ceilingEntry(K k) {
        Entry ceilingEntry = g().ceilingEntry(k);
        return ceilingEntry == null ? null : a(ceilingEntry);
    }

    public K ceilingKey(K k) {
        return g().ceilingKey(k);
    }

    /* renamed from: d */
    public NavigableMap<K, Collection<V>> tailMap(K k) {
        return tailMap(k, true);
    }

    /* renamed from: d */
    NavigableSet<K> h() {
        return new q(this.c, g());
    }

    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, Collection<V>> descendingMap() {
        return new p(this.c, g().descendingMap());
    }

    public Entry<K, Collection<V>> firstEntry() {
        Entry firstEntry = g().firstEntry();
        return firstEntry == null ? null : a(firstEntry);
    }

    public Entry<K, Collection<V>> floorEntry(K k) {
        Entry floorEntry = g().floorEntry(k);
        return floorEntry == null ? null : a(floorEntry);
    }

    public K floorKey(K k) {
        return g().floorKey(k);
    }

    public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
        return new p(this.c, g().headMap(k, z));
    }

    public Entry<K, Collection<V>> higherEntry(K k) {
        Entry higherEntry = g().higherEntry(k);
        return higherEntry == null ? null : a(higherEntry);
    }

    public K higherKey(K k) {
        return g().higherKey(k);
    }

    public Entry<K, Collection<V>> lastEntry() {
        Entry lastEntry = g().lastEntry();
        return lastEntry == null ? null : a(lastEntry);
    }

    public Entry<K, Collection<V>> lowerEntry(K k) {
        Entry lowerEntry = g().lowerEntry(k);
        return lowerEntry == null ? null : a(lowerEntry);
    }

    public K lowerKey(K k) {
        return g().lowerKey(k);
    }

    public NavigableSet<K> navigableKeySet() {
        return keySet();
    }

    public Entry<K, Collection<V>> pollFirstEntry() {
        return a(entrySet().iterator());
    }

    public Entry<K, Collection<V>> pollLastEntry() {
        return a(descendingMap().entrySet().iterator());
    }

    public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
        return new p(this.c, g().subMap(k, z, k2, z2));
    }

    public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
        return new p(this.c, g().tailMap(k, z));
    }
}
