package com.google.common.collect;

import com.google.common.collect.HashBiMap.com/google/common/collect/cq;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class ck extends gk<K, V> {
    final /* synthetic */ HashBiMap a;

    private ck(HashBiMap hashBiMap) {
        this.a = hashBiMap;
    }

    Map<K, V> a() {
        return this.a;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new com/google/common/collect/cq<Entry<K, V>>() {
            {
                HashBiMap hashBiMap = ck.this.a;
            }

            /* renamed from: a */
            Entry<K, V> b(cj<K, V> cjVar) {
                return new cl(this, cjVar);
            }
        };
    }
}
