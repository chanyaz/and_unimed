package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedSet<E> extends ep<E> implements SortedIterable<E>, NavigableSet<E> {
    private static final Comparator<Comparable> c = hd.b();
    private static final ImmutableSortedSet<Comparable> d = new bu(c);
    final transient Comparator<? super E> a;
    @GwtIncompatible("NavigableSet")
    transient ImmutableSortedSet<E> b;

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.a = comparator;
    }

    static int a(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    static <E> ImmutableSortedSet<E> a(Comparator<? super E> comparator) {
        return c.equals(comparator) ? i() : new bu(comparator);
    }

    static <E> ImmutableSortedSet<E> a(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return a((Comparator) comparator);
        }
        hc.c(eArr, i);
        Arrays.sort(eArr, 0, i, comparator);
        int i2 = 1;
        int i3 = 1;
        while (i2 < i) {
            int i4;
            Object obj = eArr[i2];
            if (comparator.compare(obj, eArr[i3 - 1]) != 0) {
                i4 = i3 + 1;
                eArr[i3] = obj;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        Arrays.fill(eArr, i3, i, null);
        return new hu(ImmutableList.b((Object[]) eArr, i3), comparator);
    }

    public static <E> ImmutableSortedSet<E> a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        s.a((Object) comparator);
        if (if.a(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.c()) {
                return immutableSortedSet;
            }
        }
        Object[] c = eq.c(iterable);
        return a((Comparator) comparator, c.length, c);
    }

    public static <E> ImmutableSortedSet<E> a(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return a((Comparator) comparator, (Iterable) collection);
    }

    private static <E> ImmutableSortedSet<E> i() {
        return d;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* renamed from: a */
    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet(e, true);
    }

    /* renamed from: a */
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    abstract ImmutableSortedSet<E> a(E e, boolean z);

    abstract ImmutableSortedSet<E> a(E e, boolean z, E e2, boolean z2);

    int b(Object obj, Object obj2) {
        return a(this.a, obj, obj2);
    }

    /* renamed from: b */
    public ImmutableSortedSet<E> headSet(E e) {
        return headSet(e, false);
    }

    abstract ImmutableSortedSet<E> b(E e, boolean z);

    @GwtIncompatible("NavigableSet")
    /* renamed from: b */
    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        s.a((Object) e);
        s.a((Object) e2);
        s.a(this.a.compare(e, e2) <= 0);
        return a(e, z, e2, z2);
    }

    abstract int c(@Nullable Object obj);

    @GwtIncompatible("NavigableSet")
    /* renamed from: c */
    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return a(s.a((Object) e), z);
    }

    @GwtIncompatible("NavigableSet")
    public E ceiling(E e) {
        return eq.a(tailSet(e, true), null);
    }

    public Comparator<? super E> comparator() {
        return this.a;
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: d */
    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return b(s.a((Object) e), z);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: d */
    public abstract jl<E> descendingIterator();

    @GwtIncompatible("NavigableSet")
    ImmutableSortedSet<E> e() {
        return new bo(this);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: e_ */
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.b;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = e();
        this.b = immutableSortedSet;
        immutableSortedSet.b = this;
        return immutableSortedSet;
    }

    public E first() {
        return iterator().next();
    }

    @GwtIncompatible("NavigableSet")
    public E floor(E e) {
        return er.b(headSet(e, true).descendingIterator(), null);
    }

    /* renamed from: h_ */
    public abstract jl<E> iterator();

    @GwtIncompatible("NavigableSet")
    public E higher(E e) {
        return eq.a(tailSet(e, false), null);
    }

    public E last() {
        return descendingIterator().next();
    }

    @GwtIncompatible("NavigableSet")
    public E lower(E e) {
        return er.b(headSet(e, false).descendingIterator(), null);
    }

    @GwtIncompatible("NavigableSet")
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible("NavigableSet")
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new eo(this.a, toArray());
    }
}
