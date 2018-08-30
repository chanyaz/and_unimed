package com.google.common.cache;

import com.google.common.cache.LocalCache.com/google/common/cache/t;

final class u extends com/google/common/cache/t<K> {
    final /* synthetic */ LocalCache a;

    u(LocalCache localCache) {
        this.a = localCache;
        super(localCache);
    }

    public K next() {
        return e().getKey();
    }
}
