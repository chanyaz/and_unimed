package com.google.common.cache;

abstract class p<K, V> implements ReferenceEntry<K, V> {
    p() {
    }

    public long getAccessTime() {
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
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    public void setWriteTime(long j) {
        throw new UnsupportedOperationException();
    }
}
