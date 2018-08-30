package com.google.common.cache;

import com.google.common.cache.LocalCache.com/google/common/cache/o;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class v extends com/google/common/cache/o<K> {
    final /* synthetic */ LocalCache c;

    v(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.c = localCache;
        super(localCache, concurrentMap);
    }

    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public Iterator<K> iterator() {
        return new u(this.c);
    }

    public boolean remove(Object obj) {
        return this.a.remove(obj) != null;
    }
}
