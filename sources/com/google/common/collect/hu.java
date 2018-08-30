package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class hu<E> extends ImmutableSortedSet<E> {
    private final transient ImmutableList<E> c;

    hu(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.c = immutableList;
        s.a(!immutableList.isEmpty());
    }

    private int e(Object obj) {
        return Collections.binarySearch(this.c, obj, i());
    }

    int a(Object[] objArr, int i) {
        return this.c.a(objArr, i);
    }

    ImmutableSortedSet<E> a(int i, int i2) {
        return (i == 0 && i2 == size()) ? this : i < i2 ? new hu(this.c.subList(i, i2), this.a) : ImmutableSortedSet.a(this.a);
    }

    ImmutableSortedSet<E> a(E e, boolean z) {
        return a(f(e, z), size());
    }

    ImmutableSortedSet<E> a(E e, boolean z, E e2, boolean z2) {
        return a((Object) e, z).b((Object) e2, z2);
    }

    ImmutableSortedSet<E> b(E e, boolean z) {
        return a(0, e(e, z));
    }

    int c(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int a = SortedLists.a(this.c, obj, i(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            if (a < 0) {
                a = -1;
            }
            return a;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    boolean c() {
        return this.c.c();
    }

    public E ceiling(E e) {
        int f = f(e, true);
        return f == size() ? null : this.c.get(f);
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return e(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        Collection collection2;
        if (collection2 instanceof Multiset) {
            collection2 = ((Multiset) collection2).elementSet();
        }
        if (!if.a(comparator(), collection2) || collection2.size() <= 1) {
            return super.containsAll(collection2);
        }
        PeekingIterator h = er.h(iterator());
        Iterator it = collection2.iterator();
        Object next = it.next();
        while (h.hasNext()) {
            try {
                int b = b(h.peek(), next);
                if (b < 0) {
                    h.next();
                } else if (b == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (b > 0) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return false;
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: d */
    public jl<E> descendingIterator() {
        return this.c.h().iterator();
    }

    int e(E e, boolean z) {
        return SortedLists.a(this.c, s.a((Object) e), comparator(), z ? KeyPresentBehavior.FIRST_AFTER : KeyPresentBehavior.FIRST_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
    }

    ImmutableSortedSet<E> e() {
        return new hu(this.c.h(), hd.a(this.a).a());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (!if.a(this.a, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            Iterator h_ = iterator();
            while (h_.hasNext()) {
                Object next = h_.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (b(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    int f(E e, boolean z) {
        return SortedLists.a(this.c, s.a((Object) e), comparator(), z ? KeyPresentBehavior.FIRST_PRESENT : KeyPresentBehavior.FIRST_AFTER, KeyAbsentBehavior.NEXT_HIGHER);
    }

    ImmutableList<E> f() {
        return new eg(this, this.c);
    }

    public E first() {
        return this.c.get(0);
    }

    public E floor(E e) {
        int e2 = e(e, true) - 1;
        return e2 == -1 ? null : this.c.get(e2);
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return this.c.iterator();
    }

    public E higher(E e) {
        int f = f(e, false);
        return f == size() ? null : this.c.get(f);
    }

    Comparator<Object> i() {
        return this.a;
    }

    public boolean isEmpty() {
        return false;
    }

    public E last() {
        return this.c.get(size() - 1);
    }

    public E lower(E e) {
        int e2 = e(e, false) - 1;
        return e2 == -1 ? null : this.c.get(e2);
    }

    public int size() {
        return this.c.size();
    }
}
