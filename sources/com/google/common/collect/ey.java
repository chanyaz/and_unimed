package com.google.common.collect;

import javax.annotation.Nullable;

final class ey<K, V> extends ad<K, V> {
    final K a;
    V b;
    ey<K, V> c;
    ey<K, V> d;
    ey<K, V> e = null;
    ey<K, V> f = null;

    ey(@Nullable K k, @Nullable V v) {
        this.a = k;
        this.b = v;
    }

    public K getKey() {
        return this.a;
    }

    public V getValue() {
        return this.b;
    }

    public V setValue(@Nullable V v) {
        V v2 = this.b;
        this.b = v;
        return v2;
    }
}
