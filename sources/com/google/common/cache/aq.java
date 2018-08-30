package com.google.common.cache;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class aq implements Entry<K, V> {
    final K a;
    V b;
    final /* synthetic */ LocalCache c;

    aq(LocalCache localCache, K k, V v) {
        this.c = localCache;
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
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
