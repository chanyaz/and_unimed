package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class bz<K, V> extends cc implements Map<K, V> {
    protected bz() {
    }

    /* renamed from: a */
    protected abstract Map<K, V> b();

    public void clear() {
        b().clear();
    }

    public boolean containsKey(@Nullable Object obj) {
        return b().containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return b().containsValue(obj);
    }

    public Set<Entry<K, V>> entrySet() {
        return b().entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || b().equals(obj);
    }

    public V get(@Nullable Object obj) {
        return b().get(obj);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public boolean isEmpty() {
        return b().isEmpty();
    }

    public Set<K> keySet() {
        return b().keySet();
    }

    public V put(K k, V v) {
        return b().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        b().putAll(map);
    }

    public V remove(Object obj) {
        return b().remove(obj);
    }

    public int size() {
        return b().size();
    }

    public Collection<V> values() {
        return b().values();
    }
}
