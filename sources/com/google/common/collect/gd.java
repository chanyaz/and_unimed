package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class gd<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
    final int a;
    final ReferenceEntry<K, V> b;
    volatile ValueReference<K, V> c = MapMakerInternalMap.g();

    gd(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, referenceQueue);
        this.a = i;
        this.b = referenceEntry;
    }

    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }

    public int getHash() {
        return this.a;
    }

    public K getKey() {
        return get();
    }

    public ReferenceEntry<K, V> getNext() {
        return this.b;
    }

    public ReferenceEntry<K, V> getNextEvictable() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getNextExpirable() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getPreviousEvictable() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getPreviousExpirable() {
        throw new UnsupportedOperationException();
    }

    public ValueReference<K, V> getValueReference() {
        return this.c;
    }

    public void setExpirationTime(long j) {
        throw new UnsupportedOperationException();
    }

    public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        throw new UnsupportedOperationException();
    }

    public void setValueReference(ValueReference<K, V> valueReference) {
        ValueReference valueReference2 = this.c;
        this.c = valueReference;
        valueReference2.clear(valueReference);
    }
}
