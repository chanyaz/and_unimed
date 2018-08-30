package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    private static final Entry<?, ?>[] a = new Entry[0];
    private transient ImmutableSet<Entry<K, V>> b;
    private transient ImmutableSet<K> c;
    private transient ImmutableCollection<V> d;

    ImmutableMap() {
    }

    public static <K, V> ImmutableMap<K, V> a(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.e()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            return b(map);
        }
        Entry[] entryArr = (Entry[]) map.entrySet().toArray(a);
        switch (entryArr.length) {
            case 0:
                return i();
            case 1:
                Entry entry = entryArr[0];
                return b(entry.getKey(), entry.getValue());
            default:
                return new hm(entryArr);
        }
    }

    static void a(boolean z, String str, Entry<?, ?> entry, Entry<?, ?> entry2) {
        if (!z) {
            throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
        }
    }

    public static <K, V> ImmutableMap<K, V> b(K k, V v) {
        return ImmutableBiMap.a(k, v);
    }

    private static <K, V> ImmutableMap<K, V> b(Map<? extends K, ? extends V> map) {
        return c((EnumMap) map);
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> c(Map<K, ? extends V> map) {
        EnumMap enumMap = new EnumMap(map);
        for (Entry entry : enumMap.entrySet()) {
            ba.a(entry.getKey(), entry.getValue());
        }
        return da.a(enumMap);
    }

    static <K, V> dl<K, V> c(K k, V v) {
        ba.a((Object) k, (Object) v);
        return new dl(k, v);
    }

    public static <K, V> ImmutableMap<K, V> i() {
        return ImmutableBiMap.g();
    }

    public static <K, V> di<K, V> j() {
        return new di();
    }

    ImmutableSet<K> a() {
        return new do(this);
    }

    /* renamed from: b */
    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.b;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = c();
        this.b = immutableSet;
        return immutableSet;
    }

    abstract ImmutableSet<Entry<K, V>> c();

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@Nullable Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@Nullable Object obj) {
        return values().contains(obj);
    }

    /* renamed from: d */
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.c;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = a();
        this.c = immutableSet;
        return immutableSet;
    }

    abstract boolean e();

    public boolean equals(@Nullable Object obj) {
        return Maps.d(this, obj);
    }

    /* renamed from: f */
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.d;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = new dq(this);
        this.d = immutableCollection;
        return immutableCollection;
    }

    public abstract V get(@Nullable Object obj);

    public int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.a((Map) this);
    }

    Object writeReplace() {
        return new dj(this);
    }
}
