package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableSet")
final class ib<E> extends cf<E> implements Serializable, NavigableSet<E> {
    private static final long serialVersionUID = 0;
    private final NavigableSet<E> a;
    private transient ib<E> b;

    ib(NavigableSet<E> navigableSet) {
        this.a = (NavigableSet) s.a((Object) navigableSet);
    }

    public E ceiling(E e) {
        return this.a.ceiling(e);
    }

    /* renamed from: d */
    protected SortedSet<E> c() {
        return Collections.unmodifiableSortedSet(this.a);
    }

    public Iterator<E> descendingIterator() {
        return er.a(this.a.descendingIterator());
    }

    public NavigableSet<E> descendingSet() {
        NavigableSet navigableSet = this.b;
        if (navigableSet != null) {
            return navigableSet;
        }
        navigableSet = new ib(this.a.descendingSet());
        this.b = navigableSet;
        navigableSet.b = this;
        return navigableSet;
    }

    public E floor(E e) {
        return this.a.floor(e);
    }

    public NavigableSet<E> headSet(E e, boolean z) {
        return hz.a(this.a.headSet(e, z));
    }

    public E higher(E e) {
        return this.a.higher(e);
    }

    public E lower(E e) {
        return this.a.lower(e);
    }

    public E pollFirst() {
        throw new UnsupportedOperationException();
    }

    public E pollLast() {
        throw new UnsupportedOperationException();
    }

    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return hz.a(this.a.subSet(e, z, e2, z2));
    }

    public NavigableSet<E> tailSet(E e, boolean z) {
        return hz.a(this.a.tailSet(e, z));
    }
}
