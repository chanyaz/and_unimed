package com.google.common.collect;

enum fr implements ReferenceEntry<Object, Object> {
    INSTANCE;

    public long getExpirationTime() {
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

    public ReferenceEntry<Object, Object> getNextEvictable() {
        return this;
    }

    public ReferenceEntry<Object, Object> getNextExpirable() {
        return this;
    }

    public ReferenceEntry<Object, Object> getPreviousEvictable() {
        return this;
    }

    public ReferenceEntry<Object, Object> getPreviousExpirable() {
        return this;
    }

    public ValueReference<Object, Object> getValueReference() {
        return null;
    }

    public void setExpirationTime(long j) {
    }

    public void setNextEvictable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setNextExpirable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setPreviousEvictable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setPreviousExpirable(ReferenceEntry<Object, Object> referenceEntry) {
    }

    public void setValueReference(ValueReference<Object, Object> valueReference) {
    }
}
