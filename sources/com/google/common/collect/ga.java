package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

final class ga<K, V> implements ValueReference<K, V> {
    final V a;

    ga(V v) {
        this.a = v;
    }

    public void clear(ValueReference<K, V> valueReference) {
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return this;
    }

    public V get() {
        return this.a;
    }

    public ReferenceEntry<K, V> getEntry() {
        return null;
    }

    public boolean isComputingReference() {
        return false;
    }

    public V waitForValue() {
        return get();
    }
}
