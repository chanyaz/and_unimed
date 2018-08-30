package com.google.common.cache;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ac<K, V> extends ad<K, V> {
    volatile long a = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> b = LocalCache.j();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> c = LocalCache.j();
    volatile long d = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> e = LocalCache.j();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> f = LocalCache.j();

    ac(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public long getAccessTime() {
        return this.a;
    }

    public ReferenceEntry<K, V> getNextInAccessQueue() {
        return this.b;
    }

    public ReferenceEntry<K, V> getNextInWriteQueue() {
        return this.e;
    }

    public ReferenceEntry<K, V> getPreviousInAccessQueue() {
        return this.c;
    }

    public ReferenceEntry<K, V> getPreviousInWriteQueue() {
        return this.f;
    }

    public long getWriteTime() {
        return this.d;
    }

    public void setAccessTime(long j) {
        this.a = j;
    }

    public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.b = referenceEntry;
    }

    public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.e = referenceEntry;
    }

    public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
        this.c = referenceEntry;
    }

    public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
        this.f = referenceEntry;
    }

    public void setWriteTime(long j) {
        this.d = j;
    }
}
