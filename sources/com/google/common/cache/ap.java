package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

final class ap<K, V> extends al<K, V> {
    final int b;

    ap(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
        super(referenceQueue, v, referenceEntry);
        this.b = i;
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new ap(referenceQueue, v, referenceEntry, this.b);
    }

    public int getWeight() {
        return this.b;
    }
}
