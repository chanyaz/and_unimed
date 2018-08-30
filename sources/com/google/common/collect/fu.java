package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

final class fu<K, V> extends SoftReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> a;

    fu(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        super(v, referenceQueue);
        this.a = referenceEntry;
    }

    public void clear(ValueReference<K, V> valueReference) {
        clear();
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new fu(referenceQueue, v, referenceEntry);
    }

    public ReferenceEntry<K, V> getEntry() {
        return this.a;
    }

    public boolean isComputingReference() {
        return false;
    }

    public V waitForValue() {
        return get();
    }
}
