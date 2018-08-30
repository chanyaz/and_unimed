package com.google.common.collect;

abstract class fh<K, V> implements ReferenceEntry<K, V> {
    fh() {
    }

    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }

    public int getHash() {
        throw new UnsupportedOperationException();
    }

    public K getKey() {
        throw new UnsupportedOperationException();
    }

    public ReferenceEntry<K, V> getNext() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }
}
