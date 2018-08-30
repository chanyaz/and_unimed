package com.google.common.collect;

import com.google.common.base.s;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class fe<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalListener<K, V> a;
    private final ff b;

    fe(MapMaker mapMaker) {
        this.a = mapMaker.a();
        this.b = mapMaker.j;
    }

    void a(K k, V v) {
        this.a.onRemoval(new fg(k, v, this.b));
    }

    public boolean containsKey(@Nullable Object obj) {
        return false;
    }

    public boolean containsValue(@Nullable Object obj) {
        return false;
    }

    public Set<Entry<K, V>> entrySet() {
        return Collections.emptySet();
    }

    public V get(@Nullable Object obj) {
        return null;
    }

    public V put(K k, V v) {
        s.a((Object) k);
        s.a((Object) v);
        a(k, v);
        return null;
    }

    public V putIfAbsent(K k, V v) {
        return put(k, v);
    }

    public V remove(@Nullable Object obj) {
        return null;
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        return false;
    }

    public V replace(K k, V v) {
        s.a((Object) k);
        s.a((Object) v);
        return null;
    }

    public boolean replace(K k, @Nullable V v, V v2) {
        s.a((Object) k);
        s.a((Object) v2);
        return false;
    }
}
