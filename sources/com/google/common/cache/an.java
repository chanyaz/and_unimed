package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

final class an<K, V> extends z<K, V> {
    final int b;

    an(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
        super(referenceQueue, v, referenceEntry);
        this.b = i;
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new an(referenceQueue, v, referenceEntry, this.b);
    }

    public int getWeight() {
        return this.b;
    }
}
