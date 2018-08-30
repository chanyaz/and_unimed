package com.google.common.cache;

import javax.annotation.Nullable;

class ad<K, V> extends p<K, V> {
    final K g;
    final int h;
    final ReferenceEntry<K, V> i;
    volatile ValueReference<K, V> j = LocalCache.i();

    ad(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        this.g = k;
        this.h = i;
        this.i = referenceEntry;
    }

    public int getHash() {
        return this.h;
    }

    public K getKey() {
        return this.g;
    }

    public ReferenceEntry<K, V> getNext() {
        return this.i;
    }

    public ValueReference<K, V> getValueReference() {
        return this.j;
    }

    public void setValueReference(ValueReference<K, V> valueReference) {
        this.j = valueReference;
    }
}
