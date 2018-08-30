package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> extends ae<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> a;
    final transient int b;

    boolean a() {
        return this.a.e();
    }

    @Deprecated
    /* renamed from: b */
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public ImmutableSet<K> keySet() {
        return this.a.keySet();
    }

    /* renamed from: c */
    public abstract ImmutableCollection<V> get(K k);

    /* renamed from: c */
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.a;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return obj != null && super.containsValue(obj);
    }

    /* renamed from: d */
    public ImmutableCollection<Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Deprecated
    /* renamed from: d */
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    ImmutableCollection<Entry<K, V>> j() {
        return new ds(this);
    }

    Map<K, Collection<V>> i() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: m */
    jl<Entry<K, V>> h() {
        return new com/google/common/collect/du<Entry<K, V>>() {
            /* renamed from: a */
            Entry<K, V> b(K k, V v) {
                return Maps.a((Object) k, (Object) v);
            }
        };
    }

    /* renamed from: n */
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    /* renamed from: o */
    ImmutableMultiset<K> k() {
        return new dv(this);
    }

    /* renamed from: p */
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: q */
    ImmutableCollection<V> l() {
        return new dw(this);
    }

    /* renamed from: r */
    jl<V> g() {
        return new com/google/common/collect/du<V>() {
            V b(K k, V v) {
                return v;
            }
        };
    }

    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.b;
    }
}
