package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class fl extends AbstractSet<Entry<K, V>> {
    final /* synthetic */ MapMakerInternalMap a;

    fl(MapMakerInternalMap mapMakerInternalMap) {
        this.a = mapMakerInternalMap;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            return false;
        }
        key = this.a.get(key);
        return key != null && this.a.f.a(entry.getValue(), key);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<Entry<K, V>> iterator() {
        return new fk(this.a);
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        return key != null && this.a.remove(key, entry.getValue());
    }

    public int size() {
        return this.a.size();
    }
}
