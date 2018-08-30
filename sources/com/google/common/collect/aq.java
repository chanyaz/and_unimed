package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
abstract class aq<K, V> extends an<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public SortedSet<V> get(@Nullable K k) {
        return (SortedSet) super.get((Object) k);
    }

    /* renamed from: p */
    abstract SortedSet<V> c();

    /* renamed from: q */
    SortedSet<V> d() {
        return valueComparator() == null ? Collections.unmodifiableSortedSet(c()) : ImmutableSortedSet.a(valueComparator());
    }

    public SortedSet<V> removeAll(@Nullable Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    public SortedSet<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((Object) k, (Iterable) iterable);
    }

    public Collection<V> values() {
        return super.values();
    }
}
