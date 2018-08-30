package com.google.common.cache;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class af<K, V> extends ad<K, V> {
    volatile long a = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> b = LocalCache.j();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> c = LocalCache.j();

    af(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public ReferenceEntry<K, V> getNextInWriteQueue() {
        return this.b;
    }

    public ReferenceEntry<K, V> getPreviousInWriteQueue() {
        return this.c;
    }

    public long getWriteTime() {
        return this.a;
    }

    public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.b = referenceEntry;
    }

    public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.c = referenceEntry;
    }

    public void setWriteTime(long j) {
        this.a = j;
    }
}
