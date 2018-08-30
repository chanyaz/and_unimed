package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class n<T> implements Iterator<T> {
    final Iterator<Entry<K, Collection<V>>> b;
    K c = null;
    Collection<V> d = null;
    Iterator<V> e = er.c();
    final /* synthetic */ j f;

    n(j jVar) {
        this.f = jVar;
        this.b = jVar.a.entrySet().iterator();
    }

    abstract T a(K k, V v);

    public boolean hasNext() {
        return this.b.hasNext() || this.e.hasNext();
    }

    public T next() {
        if (!this.e.hasNext()) {
            Entry entry = (Entry) this.b.next();
            this.c = entry.getKey();
            this.d = (Collection) entry.getValue();
            this.e = this.d.iterator();
        }
        return a(this.c, this.e.next());
    }

    public void remove() {
        this.e.remove();
        if (this.d.isEmpty()) {
            this.b.remove();
        }
        this.f.b = this.f.b - 1;
    }
}
