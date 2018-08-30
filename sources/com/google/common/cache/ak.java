package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class ak<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
    final int g;
    final ReferenceEntry<K, V> h;
    volatile ValueReference<K, V> i = LocalCache.i();

    ak(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, referenceQueue);
        this.g = i;
        this.h = referenceEntry;
    }

    public long getAccessTime() {
        throw new UnsupportedOperationException();
    }

    public int getHash() {
        return this.g;
    }

    public K getKey() {
        return get();
    }

    public ReferenceEntry<K, V> getNext() {
        return this.h;
    }

    public ReferenceEntry<K, V> getNextInAccessQueue() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getNextInWriteQueue() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getPreviousInAccessQueue() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getPreviousInWriteQueue() {
        throw new UnsupportedOperationException();
    }

    public ValueReference<K, V> getValueReference() {
        return this.i;
    }

    public long getWriteTime() {
        throw new UnsupportedOperationException();
    }

    public void setAccessTime(long j) {
        throw new UnsupportedOperationException();
    }

    public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setValueReference(ValueReference<K, V> valueReference) {
        this.i = valueReference;
    }

    public void setWriteTime(long j) {
        throw new UnsupportedOperationException();
    }
}
