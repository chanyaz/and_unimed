package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import javax.annotation.Nullable;

final class bn<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> b;

    bn(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.b = immutableSortedMultiset;
    }

    /* renamed from: a */
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.b.tailMultiset(e, boundType).descendingMultiset();
    }

    /* renamed from: a */
    public ImmutableSortedSet<E> elementSet() {
        return this.b.elementSet().descendingSet();
    }

    Entry<E> a(int i) {
        return (Entry) this.b.entrySet().b().h().get(i);
    }

    /* renamed from: b */
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.b.headMultiset((Object) e, boundType).descendingMultiset();
    }

    boolean c() {
        return this.b.c();
    }

    public int count(@Nullable Object obj) {
        return this.b.count(obj);
    }

    public Entry<E> firstEntry() {
        return this.b.lastEntry();
    }

    /* renamed from: g_ */
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.b;
    }

    public Entry<E> lastEntry() {
        return this.b.firstEntry();
    }

    public int size() {
        return this.b.size();
    }
}
