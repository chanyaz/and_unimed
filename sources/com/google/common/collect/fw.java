package com.google.common.collect;

import javax.annotation.Nullable;

class fw<K, V> implements ReferenceEntry<K, V> {
    final K a;
    final int b;
    final ReferenceEntry<K, V> c;
    volatile ValueReference<K, V> d = MapMakerInternalMap.g();

    fw(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        this.a = k;
        this.b = i;
        this.c = referenceEntry;
    }

    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }

    public int getHash() {
        return this.b;
    }

    public K getKey() {
        return this.a;
    }

    public ReferenceEntry<K, V> getNext() {
        return this.c;
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
        return this.d;
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
        ValueReference valueReference2 = this.d;
        this.d = valueReference;
        valueReference2.clear(valueReference);
    }
}
