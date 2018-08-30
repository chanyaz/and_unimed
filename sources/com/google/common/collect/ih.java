package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

class ih<E> extends gx<E> implements SortedSet<E> {
    private final SortedMultiset<E> a;

    ih(SortedMultiset<E> sortedMultiset) {
        this.a = sortedMultiset;
    }

    /* renamed from: b */
    final SortedMultiset<E> a() {
        return this.a;
    }

    public Comparator<? super E> comparator() {
        return a().comparator();
    }

    public E first() {
        return ig.c(a().firstEntry());
    }

    public SortedSet<E> headSet(E e) {
        return a().headMultiset(e, BoundType.OPEN).elementSet();
    }

    public E last() {
        return ig.c(a().lastEntry());
    }

    public SortedSet<E> subSet(E e, E e2) {
        return a().subMultiset(e, BoundType.CLOSED, e2, BoundType.OPEN).elementSet();
    }

    public SortedSet<E> tailSet(E e) {
        return a().tailMultiset(e, BoundType.CLOSED).elementSet();
    }
}
