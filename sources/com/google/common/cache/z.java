package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class z<K, V> extends SoftReference<V> implements ValueReference<K, V> {
    final ReferenceEntry<K, V> a;

    z(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        super(v, referenceQueue);
        this.a = referenceEntry;
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
        return new z(referenceQueue, v, referenceEntry);
    }

    public ReferenceEntry<K, V> getEntry() {
        return this.a;
    }

    public int getWeight() {
        return 1;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isLoading() {
        return false;
    }

    public void notifyNewValue(V v) {
    }

    public V waitForValue() {
        return get();
    }
}
