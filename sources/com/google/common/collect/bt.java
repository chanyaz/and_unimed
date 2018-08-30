package com.google.common.collect;

import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.Nullable;

final class bt<E> extends ImmutableSortedMultiset<E> {
    private final ImmutableSortedSet<E> b;

    bt(Comparator<? super E> comparator) {
        this.b = ImmutableSortedSet.a((Comparator) comparator);
    }

    int a(Object[] objArr, int i) {
        return i;
    }

    /* renamed from: a */
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        s.a((Object) e);
        s.a((Object) boundType);
        return this;
    }

    /* renamed from: a */
    public ImmutableSortedSet<E> elementSet() {
        return this.b;
    }

    Entry<E> a(int i) {
        throw new AssertionError("should never be called");
    }

    public ImmutableList<E> b() {
        return ImmutableList.e();
    }

    /* renamed from: b */
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        s.a((Object) e);
        s.a((Object) boundType);
        return this;
    }

    boolean c() {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    public int count(@Nullable Object obj) {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof Multiset ? ((Multiset) obj).isEmpty() : false;
    }

    public Entry<E> firstEntry() {
        return null;
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return er.a();
    }

    public Entry<E> lastEntry() {
        return null;
    }

    public int size() {
        return 0;
    }
}
