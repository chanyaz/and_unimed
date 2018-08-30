package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ai<K, V> extends ak<K, V> {
    volatile long a = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> b = LocalCache.j();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> c = LocalCache.j();

    ai(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public long getAccessTime() {
        return this.a;
    }

    public ReferenceEntry<K, V> getNextInAccessQueue() {
        return this.b;
    }

    public ReferenceEntry<K, V> getPreviousInAccessQueue() {
        return this.c;
    }

    public void setAccessTime(long j) {
        this.a = j;
    }

    public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.b = referenceEntry;
    }

    public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.c = referenceEntry;
    }
}
