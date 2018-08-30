package com.google.common.cache;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class ah extends AbstractCollection<V> {
    final /* synthetic */ LocalCache a;
    private final ConcurrentMap<?, ?> b;

    ah(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.a = localCache;
        this.b = concurrentMap;
    }

    public void clear() {
        this.b.clear();
    }

    public boolean contains(Object obj) {
        return this.b.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public Iterator<V> iterator() {
        return new ag(this.a);
    }

    public int size() {
        return this.b.size();
    }
}
