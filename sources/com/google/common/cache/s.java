package com.google.common.cache;

import com.google.common.cache.LocalCache.com/google/common/cache/o;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

final class s extends com/google/common/cache/o<Entry<K, V>> {
    final /* synthetic */ LocalCache c;

    s(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
        this.c = localCache;
        super(localCache, concurrentMap);
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            return false;
        }
        key = this.c.get(key);
        return key != null && this.c.g.a(entry.getValue(), key);
    }

    public Iterator<Entry<K, V>> iterator() {
        return new r(this.c);
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        return key != null && this.c.remove(key, entry.getValue());
    }
}
