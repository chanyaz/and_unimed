package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
abstract class ao<K, V> extends aq<K, V> {
    /* renamed from: m */
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    /* renamed from: n */
    SortedMap<K, Collection<V>> e() {
        return (SortedMap) super.e();
    }

    /* renamed from: o */
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
