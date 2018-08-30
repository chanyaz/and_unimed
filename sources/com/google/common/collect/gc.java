package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

final class gc extends AbstractCollection<V> {
    final /* synthetic */ MapMakerInternalMap a;

    gc(MapMakerInternalMap mapMakerInternalMap) {
        this.a = mapMakerInternalMap;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<V> iterator() {
        return new gb(this.a);
    }

    public int size() {
        return this.a.size();
    }
}
