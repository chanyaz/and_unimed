package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
public abstract class cf<E> extends ce<E> implements SortedSet<E> {
    protected cf() {
    }

    public Comparator<? super E> comparator() {
        return c().comparator();
    }

    /* renamed from: d */
    protected abstract SortedSet<E> c();

    public E first() {
        return c().first();
    }

    public SortedSet<E> headSet(E e) {
        return c().headSet(e);
    }

    public E last() {
        return c().last();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return c().subSet(e, e2);
    }

    public SortedSet<E> tailSet(E e) {
        return c().tailSet(e);
    }
}
