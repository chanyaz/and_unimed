package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
class bu<E> extends ImmutableSortedSet<E> {
    bu(Comparator<? super E> comparator) {
        super(comparator);
    }

    int a(Object[] objArr, int i) {
        return i;
    }

    ImmutableSortedSet<E> a(E e, boolean z) {
        return this;
    }

    ImmutableSortedSet<E> a(E e, boolean z, E e2, boolean z2) {
        return this;
    }

    public ImmutableList<E> b() {
        return ImmutableList.e();
    }

    ImmutableSortedSet<E> b(E e, boolean z) {
        return this;
    }

    int c(@Nullable Object obj) {
        return -1;
    }

    boolean c() {
        return false;
    }

    public boolean contains(@Nullable Object obj) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: d */
    public jl<E> descendingIterator() {
        return er.a();
    }

    ImmutableSortedSet<E> e() {
        return new bu(hd.a(this.a).a());
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof Set ? ((Set) obj).isEmpty() : false;
    }

    public E first() {
        throw new NoSuchElementException();
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return er.a();
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public E last() {
        throw new NoSuchElementException();
    }

    public int size() {
        return 0;
    }

    public String toString() {
        return "[]";
    }
}
