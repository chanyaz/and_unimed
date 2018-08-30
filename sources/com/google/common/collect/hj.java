package com.google.common.collect;

import java.io.Serializable;

class hj<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    private final ImmutableBiMap<K, V> a;

    hj(ImmutableBiMap<K, V> immutableBiMap) {
        this.a = immutableBiMap;
    }

    Object readResolve() {
        return this.a.inverse();
    }
}
