package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Comparator;

@GwtIncompatible("hasn't been tested yet")
@Beta
public abstract class ImmutableSortedMultiset<E> extends em<E> implements SortedMultiset<E> {
    private static final Comparator<Comparable> b = hd.b();
    private static final ImmutableSortedMultiset<Comparable> c = new bt(b);
    transient ImmutableSortedMultiset<E> a;

    ImmutableSortedMultiset() {
    }

    public static <E> ImmutableSortedMultiset<E> a(SortedMultiset<E> sortedMultiset) {
        return a(sortedMultiset.comparator(), fb.a(sortedMultiset.entrySet()));
    }

    static <E> ImmutableSortedMultiset<E> a(Comparator<? super E> comparator) {
        return b.equals(comparator) ? c : new bt(comparator);
    }

    private static <E> ImmutableSortedMultiset<E> a(Comparator<? super E> comparator, Collection<Entry<E>> collection) {
        if (collection.isEmpty()) {
            return a((Comparator) comparator);
        }
        de deVar = new de(collection.size());
        int[] iArr = new int[collection.size()];
        long[] jArr = new long[(collection.size() + 1)];
        int i = 0;
        for (Entry entry : collection) {
            deVar.b(entry.getElement());
            iArr[i] = entry.getCount();
            jArr[i + 1] = jArr[i] + ((long) iArr[i]);
            i++;
        }
        return new ht(new hu(deVar.a(), comparator), iArr, jArr, 0, collection.size());
    }

    /* renamed from: a */
    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    /* renamed from: a */
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        s.a(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset(e, boundType).headMultiset((Object) e2, boundType2);
    }

    /* renamed from: a */
    public abstract ImmutableSortedSet<E> elementSet();

    /* renamed from: b */
    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    /* renamed from: g_ */
    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.a;
        if (immutableSortedMultiset != null) {
            return immutableSortedMultiset;
        }
        immutableSortedMultiset = new bn(this);
        this.a = immutableSortedMultiset;
        return immutableSortedMultiset;
    }

    @Deprecated
    public final Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new el(this);
    }
}
