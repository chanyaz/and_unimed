package com.google.common.collect;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class fx<K, V> extends fw<K, V> implements ReferenceEntry<K, V> {
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> e = MapMakerInternalMap.h();
    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> f = MapMakerInternalMap.h();

    fx(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        super(k, i, referenceEntry);
    }

    public ReferenceEntry<K, V> getNextEvictable() {
        return this.e;
    }

    public ReferenceEntry<K, V> getPreviousEvictable() {
        return this.f;
    }

    public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.e = referenceEntry;
    }

    public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
        this.f = referenceEntry;
    }
}
