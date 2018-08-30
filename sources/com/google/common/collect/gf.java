package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class gf<K, V> extends gd<K, V> implements ReferenceEntry<K, V> {
    volatile long d = Long.MAX_VALUE;
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> e = MapMakerInternalMap.h();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> f = MapMakerInternalMap.h();

    gf(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public long getExpirationTime() {
        return this.d;
    }

    public ReferenceEntry<K, V> getNextExpirable() {
        return this.e;
    }

    public ReferenceEntry<K, V> getPreviousExpirable() {
        return this.f;
    }

    public void setExpirationTime(long j) {
        this.d = j;
    }

    public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.e = referenceEntry;
    }

    public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
        this.f = referenceEntry;
    }
}
