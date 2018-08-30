package com.google.common.collect;

import com.google.common.collect.HashBiMap.com/google/common/collect/cq;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

final class cm extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
    final /* synthetic */ HashBiMap a;

    private cm(HashBiMap hashBiMap) {
        this.a = hashBiMap;
    }

    BiMap<K, V> a() {
        return this.a;
    }

    public void clear() {
        a().clear();
    }

    public boolean containsKey(@Nullable Object obj) {
        return a().containsValue(obj);
    }

    public Set<Entry<V, K>> entrySet() {
        return new gk<V, K>() {
            Map<V, K> a() {
                return cm.this;
            }

            public Iterator<Entry<V, K>> iterator() {
                return new com/google/common/collect/cq<Entry<V, K>>() {
                    {
                        HashBiMap hashBiMap = cm.this.a;
                    }

                    /* renamed from: a */
                    Entry<V, K> b(cj<K, V> cjVar) {
                        return new cn(this, cjVar);
                    }
                };
            }
        };
    }

    public K forcePut(@Nullable V v, @Nullable K k) {
        return this.a.b((Object) v, (Object) k, true);
    }

    public K get(@Nullable Object obj) {
        cj b = this.a.b(obj, HashBiMap.b(obj));
        return b == null ? null : b.e;
    }

    public BiMap<K, V> inverse() {
        return a();
    }

    public Set<V> keySet() {
        return new co(this);
    }

    public K put(@Nullable V v, @Nullable K k) {
        return this.a.b((Object) v, (Object) k, false);
    }

    public K remove(@Nullable Object obj) {
        cj b = this.a.b(obj, HashBiMap.b(obj));
        if (b == null) {
            return null;
        }
        this.a.a(b);
        return b.e;
    }

    public int size() {
        return this.a.c;
    }

    public Set<K> values() {
        return a().keySet();
    }

    Object writeReplace() {
        return new cp(this.a);
    }
}
