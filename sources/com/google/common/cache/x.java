package com.google.common.cache;

enum x implements ReferenceEntry<Object, Object> {
    INSTANCE;

    public long getAccessTime() {
        return 0;
    }

    public int getHash() {
        return 0;
    }

    public Object getKey() {
        return null;
    }

    public ReferenceEntry<Object, Object> getNext() {
        return null;
    }

    public ReferenceEntry<Object, Object> getNextInAccessQueue() {
        return this;
    }

    public ReferenceEntry<Object, Object> getNextInWriteQueue() {
        return this;
    }

    public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
        return this;
    }

    public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
        return this;
    }

    public ValueReference<Object, Object> getValueReference() {
        return null;
    }

    public long getWriteTime() {
        return 0;
    }

    public void setAccessTime(long j) {
    }

    public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setValueReference(ValueReference<Object, Object> valueReference) {
    }

    public void setWriteTime(long j) {
    }
}
