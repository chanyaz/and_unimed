package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
final class jn<K, V> extends bz<K, V> {
    private final Map<K, V> a;
    private Set<Entry<K, V>> b;

    private jn(Map<K, V> map) {
        this.a = map;
    }

    static <K, V> jn<K, V> a(Map<K, V> map) {
        return new jn(map);
    }

    /* renamed from: a */
    protected Map<K, V> b() {
        return this.a;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.b;
        if (set != null) {
            return set;
        }
        set = new jo(this, null);
        this.b = set;
        return set;
    }
}
