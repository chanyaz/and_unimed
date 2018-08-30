package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class eq {
    private eq() {
    }

    public static <F, T> Iterable<T> a(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        s.a((Object) iterable);
        s.a((Object) function);
        return new bv<T>() {
            public Iterator<T> iterator() {
                return er.a(iterable.iterator(), function);
            }
        };
    }

    public static <T> Iterable<T> a(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        s.a((Object) iterable);
        s.a((Object) predicate);
        return new bv<T>() {
            public Iterator<T> iterator() {
                return er.b(iterable.iterator(), predicate);
            }
        };
    }

    @Nullable
    public static <T> T a(Iterable<? extends T> iterable, @Nullable T t) {
        return er.b(iterable.iterator(), (Object) t);
    }

    private static <T> T a(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static String a(Iterable<?> iterable) {
        return er.c(iterable.iterator());
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll(bb.a((Iterable) iterable)) : er.a((Collection) collection, ((Iterable) s.a((Object) iterable)).iterator());
    }

    public static <T> T b(Iterable<T> iterable) {
        return er.d(iterable.iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, Predicate<? super T> predicate) {
        return er.d(iterable.iterator(), predicate);
    }

    static Object[] c(Iterable<?> iterable) {
        return e(iterable).toArray();
    }

    public static <T> T d(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return er.e(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return a(list);
        }
        throw new NoSuchElementException();
    }

    private static <E> Collection<E> e(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : fb.a(iterable.iterator());
    }
}
