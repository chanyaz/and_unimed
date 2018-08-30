package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class l extends gk<K, Collection<V>> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    Map<K, Collection<V>> a() {
        return this.a;
    }

    public boolean contains(Object obj) {
        return bb.a(this.a.a.entrySet(), obj);
    }

    public Iterator<Entry<K, Collection<V>>> iterator() {
        return new m(this.a);
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.a.b.c(((Entry) obj).getKey());
        return true;
    }
}
