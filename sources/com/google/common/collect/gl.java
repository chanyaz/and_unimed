package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
abstract class gl<K, V> extends AbstractMap<K, V> {
    private transient Set<Entry<K, V>> a;
    private transient Set<K> b;
    private transient Collection<V> c;

    gl() {
    }

    abstract Set<Entry<K, V>> a();

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.a;
        if (set != null) {
            return set;
        }
        set = a();
        this.a = set;
        return set;
    }

    Set<K> h() {
        return new gm(this);
    }

    Collection<V> i() {
        return new go(this);
    }

    public Set<K> keySet() {
        Set<K> set = this.b;
        if (set != null) {
            return set;
        }
        set = h();
        this.b = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.c;
        if (collection != null) {
            return collection;
        }
        collection = i();
        this.c = collection;
        return collection;
    }
}
