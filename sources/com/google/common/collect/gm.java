package com.google.common.collect;

import com.google.common.base.s;
import java.util.Iterator;
import java.util.Map;

class gm<K, V> extends ia<K> {
    final Map<K, V> d;

    gm(Map<K, V> map) {
        this.d = (Map) s.a((Object) map);
    }

    Map<K, V> c() {
        return this.d;
    }

    public void clear() {
        c().clear();
    }

    public boolean contains(Object obj) {
        return c().containsKey(obj);
    }

    public boolean isEmpty() {
        return c().isEmpty();
    }

    public Iterator<K> iterator() {
        return Maps.a(c().entrySet().iterator());
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        c().remove(obj);
        return true;
    }

    public int size() {
        return c().size();
    }
}
