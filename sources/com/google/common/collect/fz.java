package com.google.common.collect;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class fz<K, V> extends fw<K, V> implements ReferenceEntry<K, V> {
    volatile long e = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> f = MapMakerInternalMap.h();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> g = MapMakerInternalMap.h();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> h = MapMakerInternalMap.h();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> i = MapMakerInternalMap.h();

    fz(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public long getExpirationTime() {
        return this.e;
    }

    public ReferenceEntry<K, V> getNextEvictable() {
        return this.h;
    }

    public ReferenceEntry<K, V> getNextExpirable() {
        return this.f;
    }

    public ReferenceEntry<K, V> getPreviousEvictable() {
        return this.i;
    }

    public ReferenceEntry<K, V> getPreviousExpirable() {
        return this.g;
    }

    public void setExpirationTime(long j) {
        this.e = j;
    }

    public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.h = referenceEntry;
    }

    public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f = referenceEntry;
    }

    public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.i = referenceEntry;
    }

    public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.g = referenceEntry;
    }
}
