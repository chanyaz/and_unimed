package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

class bo<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> c;

    bo(ImmutableSortedSet<E> immutableSortedSet) {
        super(hd.a(immutableSortedSet.comparator()).a());
        this.c = immutableSortedSet;
    }

    ImmutableSortedSet<E> a(E e, boolean z) {
        return this.c.headSet(e, z).descendingSet();
    }

    ImmutableSortedSet<E> a(E e, boolean z, E e2, boolean z2) {
        return this.c.subSet(e2, z2, e, z).descendingSet();
    }

    ImmutableSortedSet<E> b(E e, boolean z) {
        return this.c.tailSet(e, z).descendingSet();
    }

    int c(@Nullable Object obj) {
        int c = this.c.c(obj);
        return c == -1 ? c : (size() - 1) - c;
    }

    boolean c() {
        return this.c.c();
    }

    public E ceiling(E e) {
        return this.c.floor(e);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: d */
    public jl<E> descendingIterator() {
        return this.c.iterator();
    }

    @GwtIncompatible("NavigableSet")
    ImmutableSortedSet<E> e() {
        throw new AssertionError("should never be called");
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: e_ */
    public ImmutableSortedSet<E> descendingSet() {
        return this.c;
    }

    public E floor(E e) {
        return this.c.ceiling(e);
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return this.c.descendingIterator();
    }

    public E higher(E e) {
        return this.c.lower(e);
    }

    public E lower(E e) {
        return this.c.higher(e);
    }

    public int size() {
        return this.c.size();
    }
}
