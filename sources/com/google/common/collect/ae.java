package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class ae<K, V> implements Multimap<K, V> {
    private transient Collection<Entry<K, V>> a;
    private transient Set<K> b;
    private transient Multiset<K> c;
    private transient Collection<V> d;
    private transient Map<K, Collection<V>> e;

    ae() {
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.e;
        if (map != null) {
            return map;
        }
        map = i();
        this.e = map;
        return map;
    }

    public boolean containsEntry(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(@Nullable Object obj) {
        for (Collection contains : asMap().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Collection<Entry<K, V>> entries() {
        Collection<Entry<K, V>> collection = this.a;
        if (collection != null) {
            return collection;
        }
        collection = j();
        this.a = collection;
        return collection;
    }

    public boolean equals(@Nullable Object obj) {
        return gp.a(this, obj);
    }

    Set<K> f() {
        return new gm(asMap());
    }

    Iterator<V> g() {
        return Maps.b(entries().iterator());
    }

    abstract Iterator<Entry<K, V>> h();

    public int hashCode() {
        return asMap().hashCode();
    }

    abstract Map<K, Collection<V>> i();

    public boolean isEmpty() {
        return size() == 0;
    }

    Collection<Entry<K, V>> j() {
        return this instanceof SetMultimap ? new ag(this, null) : new af(this, null);
    }

    Multiset<K> k() {
        return new gt(this);
    }

    public Set<K> keySet() {
        Set<K> set = this.b;
        if (set != null) {
            return set;
        }
        set = f();
        this.b = set;
        return set;
    }

    public Multiset<K> keys() {
        Multiset<K> multiset = this.c;
        if (multiset != null) {
            return multiset;
        }
        multiset = k();
        this.c = multiset;
        return multiset;
    }

    Collection<V> l() {
        return new ah(this);
    }

    public boolean put(@Nullable K k, @Nullable V v) {
        return get(k).add(v);
    }

    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean z = false;
        Iterator it = multimap.entries().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Entry entry = (Entry) it.next();
            z = put(entry.getKey(), entry.getValue()) | z2;
        }
    }

    public boolean putAll(@Nullable K k, Iterable<? extends V> iterable) {
        s.a((Object) iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return !collection.isEmpty() && get(k).addAll(collection);
        } else {
            Iterator it = iterable.iterator();
            return it.hasNext() && er.a(get(k), it);
        }
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public Collection<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        s.a((Object) iterable);
        Collection<V> removeAll = removeAll(k);
        putAll(k, iterable);
        return removeAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.d;
        if (collection != null) {
            return collection;
        }
        collection = l();
        this.d = collection;
        return collection;
    }
}
