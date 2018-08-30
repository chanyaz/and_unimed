package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class ic<K, V> extends ImmutableBiMap<K, V> {
    final transient K a;
    final transient V b;
    transient ImmutableBiMap<V, K> c;

    ic(K k, V v) {
        ba.a((Object) k, (Object) v);
        this.a = k;
        this.b = v;
    }

    private ic(K k, V v, ImmutableBiMap<V, K> immutableBiMap) {
        this.a = k;
        this.b = v;
        this.c = immutableBiMap;
    }

    ImmutableSet<K> a() {
        return ImmutableSet.d(this.a);
    }

    ImmutableSet<Entry<K, V>> c() {
        return ImmutableSet.d(Maps.a(this.a, this.b));
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.a.equals(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return this.b.equals(obj);
    }

    boolean e() {
        return false;
    }

    public V get(@Nullable Object obj) {
        return this.a.equals(obj) ? this.b : null;
    }

    /* renamed from: i_ */
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> immutableBiMap = this.c;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        immutableBiMap = new ic(this.b, this.a, this);
        this.c = immutableBiMap;
        return immutableBiMap;
    }

    public int size() {
        return 1;
    }
}
