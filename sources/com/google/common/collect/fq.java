package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;

final class fq extends AbstractSet<K> {
    final /* synthetic */ MapMakerInternalMap a;

    fq(MapMakerInternalMap mapMakerInternalMap) {
        this.a = mapMakerInternalMap;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<K> iterator() {
        return new fp(this.a);
    }

    public boolean remove(Object obj) {
        return this.a.remove(obj) != null;
    }

    public int size() {
        return this.a.size();
    }
}
