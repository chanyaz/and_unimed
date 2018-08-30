package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class bx<K, V> extends bz<K, V> implements ConcurrentMap<K, V> {
    protected bx() {
    }

    /* renamed from: c */
    protected abstract ConcurrentMap<K, V> b();

    public V putIfAbsent(K k, V v) {
        return b().putIfAbsent(k, v);
    }

    public boolean remove(Object obj, Object obj2) {
        return b().remove(obj, obj2);
    }

    public V replace(K k, V v) {
        return b().replace(k, v);
    }

    public boolean replace(K k, V v, V v2) {
        return b().replace(k, v, v2);
    }
}
