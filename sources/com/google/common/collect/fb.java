package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.primitives.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class fb {
    private fb() {
    }

    @VisibleForTesting
    static int a(int i) {
        ba.a(i, "arraySize");
        return b.a((5 + ((long) i)) + ((long) (i / 10)));
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> a() {
        return new ArrayList();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> a(Iterable<? extends E> iterable) {
        s.a((Object) iterable);
        return iterable instanceof Collection ? new ArrayList(bb.a((Iterable) iterable)) : a(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> a(Iterator<? extends E> it) {
        Collection a = a();
        er.a(a, (Iterator) it);
        return a;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> a(E... eArr) {
        s.a((Object) eArr);
        Object arrayList = new ArrayList(a(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <F, T> List<T> a(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new fc(list, function) : new fd(list, function);
    }

    static boolean a(List<?> list, @Nullable Object obj) {
        if (obj == s.a((Object) list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        return list.size() == list2.size() && er.a(list.iterator(), list2.iterator());
    }

    static int b(List<?> list, @Nullable Object obj) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (o.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> b(int i) {
        ba.a(i, "initialArraySize");
        return new ArrayList(i);
    }

    static int c(List<?> list, @Nullable Object obj) {
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (o.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> c(int i) {
        return new ArrayList(a(i));
    }
}
