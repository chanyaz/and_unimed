package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class du<T> extends jl<T> {
    final Iterator<Entry<K, Collection<V>>> b;
    K c;
    Iterator<V> d;
    final /* synthetic */ ImmutableMultimap e;

    private du(ImmutableMultimap immutableMultimap) {
        this.e = immutableMultimap;
        this.b = this.e.asMap().entrySet().iterator();
        this.c = null;
        this.d = er.a();
    }

    abstract T b(K k, V v);

    public boolean hasNext() {
        return this.b.hasNext() || this.d.hasNext();
    }

    public T next() {
        if (!this.d.hasNext()) {
            Entry entry = (Entry) this.b.next();
            this.c = entry.getKey();
            this.d = ((Collection) entry.getValue()).iterator();
        }
        return b(this.c, this.d.next());
    }
}
