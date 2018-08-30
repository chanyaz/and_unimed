package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import com.google.common.collect.j$com.google.common.collect.u;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class j<K, V> extends ae<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> a;
    private transient int b;

    protected j(Map<K, Collection<V>> map) {
        s.a(map.isEmpty());
        this.a = map;
    }

    private List<V> a(@Nullable K k, List<V> list, @Nullable u uVar) {
        return list instanceof RandomAccess ? new r(this, k, list, uVar) : new w(this, k, list, uVar);
    }

    static /* synthetic */ int b(j jVar, int i) {
        int i2 = jVar.b - i;
        jVar.b = i2;
        return i2;
    }

    private Collection<V> b(@Nullable K k) {
        Collection<V> collection = (Collection) this.a.get(k);
        if (collection != null) {
            return collection;
        }
        collection = a((Object) k);
        this.a.put(k, collection);
        return collection;
    }

    private Iterator<V> b(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    private int c(Object obj) {
        Collection collection = (Collection) Maps.c(this.a, obj);
        int i = 0;
        if (collection != null) {
            i = collection.size();
            collection.clear();
            this.b -= i;
        }
        return i;
    }

    Collection<V> a(@Nullable K k) {
        return c();
    }

    Collection<V> a(@Nullable K k, Collection<V> collection) {
        return collection instanceof SortedSet ? new aa(this, k, (SortedSet) collection, null) : collection instanceof Set ? new z(this, k, (Set) collection) : collection instanceof List ? a(k, (List) collection, null) : new u(this, k, collection, null);
    }

    Collection<V> a(Collection<V> collection) {
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    final void a(Map<K, Collection<V>> map) {
        this.a = map;
        this.b = 0;
        for (Collection collection : map.values()) {
            s.a(!collection.isEmpty());
            this.b = collection.size() + this.b;
        }
    }

    abstract Collection<V> c();

    public void clear() {
        for (Collection clear : this.a.values()) {
            clear.clear();
        }
        this.a.clear();
        this.b = 0;
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    Collection<V> d() {
        return a(c());
    }

    Map<K, Collection<V>> e() {
        return this.a;
    }

    public Collection<Entry<K, V>> entries() {
        return super.entries();
    }

    Set<K> f() {
        return this.a instanceof SortedMap ? new t(this, (SortedMap) this.a) : new o(this, this.a);
    }

    Iterator<V> g() {
        return new com/google/common/collect/n<V>() {
            V a(K k, V v) {
                return v;
            }
        };
    }

    public Collection<V> get(@Nullable K k) {
        Collection collection = (Collection) this.a.get(k);
        if (collection == null) {
            collection = a((Object) k);
        }
        return a((Object) k, collection);
    }

    Iterator<Entry<K, V>> h() {
        return new com/google/common/collect/n<Entry<K, V>>() {
            /* renamed from: b */
            Entry<K, V> a(K k, V v) {
                return Maps.a((Object) k, (Object) v);
            }
        };
    }

    Map<K, Collection<V>> i() {
        return this.a instanceof SortedMap ? new s(this, (SortedMap) this.a) : new k(this, this.a);
    }

    public boolean put(@Nullable K k, @Nullable V v) {
        Collection collection = (Collection) this.a.get(k);
        if (collection == null) {
            collection = a((Object) k);
            if (collection.add(v)) {
                this.b++;
                this.a.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.b++;
            return true;
        }
    }

    public Collection<V> removeAll(@Nullable Object obj) {
        Collection collection = (Collection) this.a.remove(obj);
        if (collection == null) {
            return d();
        }
        Collection c = c();
        c.addAll(collection);
        this.b -= collection.size();
        collection.clear();
        return a(c);
    }

    public Collection<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        Collection b = b((Object) k);
        Collection c = c();
        c.addAll(b);
        this.b -= b.size();
        b.clear();
        while (it.hasNext()) {
            if (b.add(it.next())) {
                this.b++;
            }
        }
        return a(c);
    }

    public int size() {
        return this.b;
    }

    public Collection<V> values() {
        return super.values();
    }
}
