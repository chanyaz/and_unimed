package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class gh<K, V> extends WeakReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> a;

    gh(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        super(v, referenceQueue);
        this.a = referenceEntry;
    }

    public void clear(ValueReference<K, V> valueReference) {
        clear();
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new gh(referenceQueue, v, referenceEntry);
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
