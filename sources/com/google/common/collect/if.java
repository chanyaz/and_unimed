package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
final class if {
    private if() {
    }

    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? hd.b() : comparator;
    }

    public static boolean a(Comparator<?> comparator, Iterable<?> iterable) {
        Object a;
        s.a((Object) comparator);
        s.a((Object) iterable);
        if (iterable instanceof SortedSet) {
            a = a((SortedSet) iterable);
        } else if (!(iterable instanceof SortedIterable)) {
            return false;
        } else {
            a = ((SortedIterable) iterable).comparator();
        }
        return comparator.equals(a);
    }
}
