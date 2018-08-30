package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class gr extends gk<K, Collection<V>> {
    final /* synthetic */ gq a;

    gr(gq gqVar) {
        this.a = gqVar;
    }

    Map<K, Collection<V>> a() {
        return this.a;
    }

    public Iterator<Entry<K, Collection<V>>> iterator() {
        return Maps.a(this.a.a.keySet(), new Function<K, Collection<V>>() {
            /* renamed from: a */
            public Collection<V> apply(K k) {
                return gr.this.a.a.get(k);
            }
        });
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.a.a(((Entry) obj).getKey());
        return true;
    }
}
