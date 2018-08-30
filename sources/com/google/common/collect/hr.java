package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class hr<K, V> extends ImmutableSortedMap<K, V> {
    private final transient hu<K> a;
    private final transient ImmutableList<V> b;

    hr(hu<K> huVar, ImmutableList<V> immutableList) {
        this.a = huVar;
        this.b = immutableList;
    }

    hr(hu<K> huVar, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.a = huVar;
        this.b = immutableList;
    }

    private ImmutableSortedMap<K, V> a(int i, int i2) {
        return (i == 0 && i2 == size()) ? this : i == i2 ? ImmutableSortedMap.a(comparator()) : ImmutableSortedMap.a(this.a.a(i, i2), this.b.subList(i, i2));
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return a(0, this.a.e(s.a((Object) k), z));
    }

    /* renamed from: b */
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return a(this.a.f(s.a((Object) k), z), size());
    }

    ImmutableSet<Entry<K, V>> c() {
        return new hs(this, null);
    }

    /* renamed from: f */
    public ImmutableCollection<V> values() {
        return this.b;
    }

    ImmutableSortedMap<K, V> g() {
        return new hr((hu) this.a.descendingSet(), this.b.h(), this);
    }

    public V get(@Nullable Object obj) {
        int c = this.a.c(obj);
        return c == -1 ? null : this.b.get(c);
    }

    /* renamed from: j_ */
    public ImmutableSortedSet<K> keySet() {
        return this.a;
    }
}
