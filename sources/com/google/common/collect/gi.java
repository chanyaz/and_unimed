package com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class gi extends ad<K, V> {
    final K a;
    V b;
    final /* synthetic */ MapMakerInternalMap c;

    gi(MapMakerInternalMap mapMakerInternalMap, K k, V v) {
        this.c = mapMakerInternalMap;
        this.a = k;
        this.b = v;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.a.equals(entry.getKey()) && this.b.equals(entry.getValue());
    }

    public K getKey() {
        return this.a;
    }

    public V getValue() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public V setValue(V v) {
        V put = this.c.put(this.a, v);
        this.b = v;
        return put;
    }
}
