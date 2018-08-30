package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class jo extends gk<K, V> {
    final /* synthetic */ jn a;

    private jo(jn jnVar) {
        this.a = jnVar;
    }

    Map<K, V> a() {
        return this.a;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new jf<K, Entry<K, V>>(this.a.keySet().iterator()) {
            /* renamed from: b */
            Entry<K, V> a(final K k) {
                return new ad<K, V>() {
                    public K getKey() {
                        return k;
                    }

                    public V getValue() {
                        return jo.this.a.get(k);
                    }

                    public V setValue(V v) {
                        return jo.this.a.put(k, v);
                    }
                };
            }
        };
    }
}
