package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class d extends ce<K> {
    final /* synthetic */ a a;

    private d(a aVar) {
        this.a = aVar;
    }

    /* renamed from: a */
    protected Set<K> c() {
        return this.a.b.keySet();
    }

    public void clear() {
        this.a.clear();
    }

    public Iterator<K> iterator() {
        return Maps.a(this.a.entrySet().iterator());
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.a.c(obj);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return c(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return d(collection);
    }
}
