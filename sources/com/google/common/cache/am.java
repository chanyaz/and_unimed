package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class am<K, V> extends ak<K, V> {
    volatile long a = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> b = LocalCache.j();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> c = LocalCache.j();

    am(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
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
