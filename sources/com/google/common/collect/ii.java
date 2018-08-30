package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtIncompatible("Navigable")
class ii<E> extends ih<E> implements NavigableSet<E> {
    ii(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    public E ceiling(E e) {
        return ig.d(a().tailMultiset(e, BoundType.CLOSED).firstEntry());
    }

    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    public NavigableSet<E> descendingSet() {
        return new ii(a().descendingMultiset());
    }

    public E floor(E e) {
        return ig.d(a().headMultiset(e, BoundType.CLOSED).lastEntry());
    }

    public NavigableSet<E> headSet(E e, boolean z) {
        return new ii(a().headMultiset(e, BoundType.a(z)));
    }

    public E higher(E e) {
        return ig.d(a().tailMultiset(e, BoundType.OPEN).firstEntry());
    }

    public E lower(E e) {
        return ig.d(a().headMultiset(e, BoundType.OPEN).lastEntry());
    }

    public E pollFirst() {
        return ig.d(a().pollFirstEntry());
    }

    public E pollLast() {
        return ig.d(a().pollLastEntry());
    }

    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return new ii(a().subMultiset(e, BoundType.a(z), e2, BoundType.a(z2)));
    }

    public NavigableSet<E> tailSet(E e, boolean z) {
        return new ii(a().tailMultiset(e, BoundType.a(z)));
    }
}
