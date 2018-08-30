package com.google.common.collect;

import java.util.Map;

public final class cv<K, V> extends di<K, V> {
    /* renamed from: a */
    public ImmutableBiMap<K, V> b() {
        switch (this.b) {
            case 0:
                return ImmutableBiMap.g();
            case 1:
                return ImmutableBiMap.a(this.a[0].getKey(), this.a[0].getValue());
            default:
                return new hg(this.b, this.a);
        }
    }

    /* renamed from: a */
    public cv<K, V> b(K k, V v) {
        super.b(k, v);
        return this;
    }

    /* renamed from: a */
    public cv<K, V> b(Map<? extends K, ? extends V> map) {
        super.b(map);
        return this;
    }
}
