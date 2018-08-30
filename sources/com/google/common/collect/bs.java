package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class bs<K, V> extends ImmutableSortedMap<K, V> {
    private final transient ImmutableSortedSet<K> a;

    bs(Comparator<? super K> comparator) {
        this.a = ImmutableSortedSet.a((Comparator) comparator);
    }

    bs(Comparator<? super K> comparator, ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.a = ImmutableSortedSet.a((Comparator) comparator);
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        s.a((Object) k);
        return this;
    }

    /* renamed from: b */
    public ImmutableSet<Entry<K, V>> entrySet() {
        return ImmutableSet.g();
    }

    /* renamed from: b */
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        s.a((Object) k);
        return this;
    }

    ImmutableSet<Entry<K, V>> c() {
        throw new AssertionError("should never be called");
    }

    boolean e() {
        return false;
    }

    /* renamed from: f */
    public ImmutableCollection<V> values() {
        return ImmutableList.e();
    }

    ImmutableSortedMap<K, V> g() {
        return new bs(hd.a(comparator()).a(), this);
    }

    public V get(@Nullable Object obj) {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    /* renamed from: j_ */
    public ImmutableSortedSet<K> keySet() {
        return this.a;
    }

    public int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
