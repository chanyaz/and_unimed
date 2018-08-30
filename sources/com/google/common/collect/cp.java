package com.google.common.collect;

import java.io.Serializable;

final class cp<K, V> implements Serializable {
    private final HashBiMap<K, V> a;

    cp(HashBiMap<K, V> hashBiMap) {
        this.a = hashBiMap;
    }

    Object readResolve() {
        return this.a.inverse();
    }
}
