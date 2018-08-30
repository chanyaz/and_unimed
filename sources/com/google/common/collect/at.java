package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

class at extends AbstractCollection<V> {
    final /* synthetic */ ar a;

    at(ar arVar) {
        this.a = arVar;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    public Iterator<V> iterator() {
        return this.a.d();
    }

    public int size() {
        return this.a.size();
    }
}
