package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ge<K, V> extends gd<K, V> implements ReferenceEntry<K, V> {
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> d = MapMakerInternalMap.h();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> e = MapMakerInternalMap.h();

    ge(ReferenceQueue<K> referenceQueue, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(referenceQueue, k, i, referenceEntry);
    }

    public ReferenceEntry<K, V> getNextEvictable() {
        return this.d;
    }

    public ReferenceEntry<K, V> getPreviousEvictable() {
        return this.e;
    }

    public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.d = referenceEntry;
    }

    public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.e = referenceEntry;
    }
}
