package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

class ae<K, V> implements ValueReference<K, V> {
    final V a;

    ae(V v) {
        this.a = v;
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
