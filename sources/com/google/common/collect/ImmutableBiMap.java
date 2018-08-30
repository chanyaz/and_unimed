package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
    private static final Entry<?, ?>[] a = new Entry[0];

    ImmutableBiMap() {
    }

    public static <K, V> ImmutableBiMap<K, V> a(K k, V v) {
        return new ic(k, v);
    }

    public static <K, V> ImmutableBiMap<K, V> g() {
        return bq.a;
    }

    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: h */
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    /* renamed from: i_ */
    public abstract ImmutableBiMap<V, K> inverse();

    Object writeReplace() {
        return new cw(this);
    }
}
