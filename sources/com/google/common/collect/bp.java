package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(emulated = true)
abstract class bp<E> extends cb<E> implements SortedMultiset<E> {
    private transient Comparator<? super E> a;
    private transient NavigableSet<E> b;
    private transient Set<Entry<E>> c;

    bp() {
    }

    abstract SortedMultiset<E> a();

    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.a;
        if (comparator != null) {
            return comparator;
        }
        comparator = hd.a(a().comparator()).a();
        this.a = comparator;
        return comparator;
    }

    abstract Iterator<Entry<E>> d();

    public SortedMultiset<E> descendingMultiset() {
        return a();
    }

    /* renamed from: e */
    protected Multiset<E> c() {
        return a();
    }

    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.b;
        if (navigableSet != null) {
            return navigableSet;
        }
        navigableSet = new ii(this);
        this.b = navigableSet;
        return navigableSet;
    }

    public Set<Entry<E>> entrySet() {
        Set<Entry<E>> set = this.c;
        if (set != null) {
            return set;
        }
        set = f();
        this.c = set;
        return set;
    }

    Set<Entry<E>> f() {
        return new gy<E>() {
            Multiset<E> a() {
                return bp.this;
            }

            public Iterator<Entry<E>> iterator() {
                return bp.this.d();
            }

            public int size() {
                return bp.this.a().entrySet().size();
            }
        };
    }

    public Entry<E> firstEntry() {
        return a().lastEntry();
    }

    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return a().tailMultiset(e, boundType).descendingMultiset();
    }

    public Iterator<E> iterator() {
        return gv.a((Multiset) this);
    }

    public Entry<E> lastEntry() {
        return a().firstEntry();
    }

    public Entry<E> pollFirstEntry() {
        return a().pollLastEntry();
    }

    public Entry<E> pollLastEntry() {
        return a().pollFirstEntry();
    }

    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return a().subMultiset(e2, boundType2, e, boundType).descendingMultiset();
    }

    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return a().headMultiset(e, boundType).descendingMultiset();
    }

    public Object[] toArray() {
        return h();
    }

    public <T> T[] toArray(T[] tArr) {
        return a((Object[]) tArr);
    }

    public String toString() {
        return entrySet().toString();
    }
}
