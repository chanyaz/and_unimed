package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class m implements Iterator<Entry<K, Collection<V>>> {
    final Iterator<Entry<K, Collection<V>>> a = this.c.a.entrySet().iterator();
    Collection<V> b;
    final /* synthetic */ k c;

    m(k kVar) {
        this.c = kVar;
    }

    /* renamed from: a */
    public Entry<K, Collection<V>> next() {
        Entry entry = (Entry) this.a.next();
        this.b = (Collection) entry.getValue();
        return this.c.a(entry);
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public void remove() {
        this.a.remove();
        j.b(this.c.b, this.b.size());
        this.b.clear();
    }
}
