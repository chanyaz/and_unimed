package com.google.common.collect;

import com.google.common.base.s;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class eh<K, V> extends di<K, V> {
    private final Comparator<? super K> c;

    public eh(Comparator<? super K> comparator) {
        this.c = (Comparator) s.a((Object) comparator);
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> b() {
        return ImmutableSortedMap.a(this.c, false, this.b, this.a);
    }

    /* renamed from: a */
    public eh<K, V> b(K k, V v) {
        super.b(k, v);
        return this;
    }

    /* renamed from: a */
    public eh<K, V> b(Map<? extends K, ? extends V> map) {
        super.b(map);
        return this;
    }

    /* renamed from: b */
    public eh<K, V> a(Entry<? extends K, ? extends V> entry) {
        super.a((Entry) entry);
        return this;
    }
}
