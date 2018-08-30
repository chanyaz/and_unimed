package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class an<K, V> extends j<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    protected an(Map<K, Collection<V>> map) {
        super(map);
    }

    /* renamed from: a */
    abstract Set<V> c();

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    /* renamed from: b */
    Set<V> d() {
        return ImmutableSet.g();
    }

    public Set<Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public Set<V> get(@Nullable K k) {
        return (Set) super.get(k);
    }

    public boolean put(@Nullable K k, @Nullable V v) {
        return super.put(k, v);
    }

    public Set<V> removeAll(@Nullable Object obj) {
        return (Set) super.removeAll(obj);
    }

    public Set<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k, iterable);
    }
}
