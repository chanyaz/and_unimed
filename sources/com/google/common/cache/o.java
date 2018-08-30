package com.google.common.cache;

import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

abstract class o<T> extends AbstractSet<T> {
    final ConcurrentMap<?, ?> a;
    final /* synthetic */ LocalCache b;

    o(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.b = localCache;
        this.a = concurrentMap;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public int size() {
        return this.a.size();
    }
}
