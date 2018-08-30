package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class hz {
    private hz() {
    }

    static int a(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            i = ((i + (next != null ? next.hashCode() : 0)) ^ -1) ^ -1;
        }
        return i;
    }

    public static <E> HashSet<E> a() {
        return new HashSet();
    }

    public static <E> HashSet<E> a(int i) {
        return new HashSet(Maps.b(i));
    }

    @GwtIncompatible("NavigableSet")
    public static <E> NavigableSet<E> a(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableSortedSet) || (navigableSet instanceof ib)) ? navigableSet : new ib(navigableSet);
    }

    static boolean a(Set<?> set, @Nullable Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    static boolean a(Set<?> set, Collection<?> collection) {
        Collection collection2;
        s.a((Object) collection2);
        if (collection2 instanceof Multiset) {
            collection2 = ((Multiset) collection2).elementSet();
        }
        return (!(collection2 instanceof Set) || collection2.size() <= set.size()) ? a((Set) set, collection2.iterator()) : er.a(set.iterator(), collection2);
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }
}
