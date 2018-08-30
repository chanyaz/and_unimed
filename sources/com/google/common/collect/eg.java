package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class eg<E> extends hf<E> implements SortedIterable<E> {
    eg(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super((ImmutableCollection) immutableSortedSet, (ImmutableList) immutableList);
    }

    @GwtIncompatible("super.subListUnchecked does not exist; inherited subList is valid if slow")
    ImmutableList<E> b(int i, int i2) {
        return new hu(super.b(i, i2), comparator()).b();
    }

    public Comparator<? super E> comparator() {
        return d().comparator();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @GwtIncompatible("ImmutableSortedSet.indexOf")
    public int indexOf(@Nullable Object obj) {
        int c = d().c(obj);
        return (c < 0 || !get(c).equals(obj)) ? -1 : c;
    }

    /* renamed from: j */
    ImmutableSortedSet<E> d() {
        return (ImmutableSortedSet) super.d();
    }

    @GwtIncompatible("ImmutableSortedSet.indexOf")
    public int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }
}
