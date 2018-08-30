package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.base.t;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class er {
    static final jm<Object> a = new jm<Object>() {
        public boolean hasNext() {
            return false;
        }

        public boolean hasPrevious() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return 0;
        }

        public Object previous() {
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return -1;
        }
    };
    private static final Iterator<Object> b = new Iterator<Object>() {
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            ba.a(false);
        }
    };

    private er() {
    }

    public static <T> jl<T> a() {
        return b();
    }

    @Beta
    public static <T> jl<T> a(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        s.a((Object) iterable, (Object) "iterators");
        s.a((Object) comparator, (Object) "comparator");
        return new es(iterable, comparator);
    }

    public static <T> jl<T> a(@Nullable final T t) {
        return new jl<T>() {
            boolean a;

            public boolean hasNext() {
                return !this.a;
            }

            public T next() {
                if (this.a) {
                    throw new NoSuchElementException();
                }
                this.a = true;
                return t;
            }
        };
    }

    public static <T> jl<T> a(final Iterator<T> it) {
        s.a((Object) it);
        return it instanceof jl ? (jl) it : new jl<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    public static <T> jl<T> a(T... tArr) {
        return a(tArr, 0, tArr.length, 0);
    }

    static <T> jm<T> a(final T[] tArr, final int i, int i2, int i3) {
        s.a(i2 >= 0);
        s.a(i, i + i2, tArr.length);
        s.b(i3, i2);
        return i2 == 0 ? b() : new f<T>(i2, i3) {
            protected T a(int i) {
                return tArr[i + i];
            }
        };
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, final Function<? super F, ? extends T> function) {
        s.a((Object) function);
        return new jf<F, T>(it) {
            T a(F f) {
                return function.apply(f);
            }
        };
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        s.a((Object) collection);
        s.a((Object) it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> boolean a(Iterator<T> it, Predicate<? super T> predicate) {
        s.a((Object) predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean a(Iterator<?> it, @Nullable Object obj) {
        return c(it, t.a(obj));
    }

    public static boolean a(Iterator<?> it, Collection<?> collection) {
        return a((Iterator) it, t.a((Collection) collection));
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!o.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static int b(Iterator<?> it) {
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
        }
        return i;
    }

    public static <T> jl<T> b(final Iterator<T> it, final Predicate<? super T> predicate) {
        s.a((Object) it);
        s.a((Object) predicate);
        return new g<T>() {
            protected T a() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return b();
            }
        };
    }

    static <T> jm<T> b() {
        return a;
    }

    @Nullable
    public static <T> T b(Iterator<? extends T> it, @Nullable T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static boolean b(Iterator<?> it, Collection<?> collection) {
        return a((Iterator) it, t.a(t.a((Collection) collection)));
    }

    public static String c(Iterator<?> it) {
        return bb.a.a(new StringBuilder().append('['), (Iterator) it).append(']').toString();
    }

    static <T> Iterator<T> c() {
        return b;
    }

    public static <T> boolean c(Iterator<T> it, Predicate<? super T> predicate) {
        return e(it, predicate) != -1;
    }

    public static <T> T d(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            stringBuilder.append(", " + it.next());
        }
        if (it.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> boolean d(Iterator<T> it, Predicate<? super T> predicate) {
        s.a((Object) predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> int e(Iterator<T> it, Predicate<? super T> predicate) {
        s.a((Object) predicate, (Object) "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> T e(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @Nullable
    static <T> T f(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    static void g(Iterator<?> it) {
        s.a((Object) it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> PeekingIterator<T> h(Iterator<? extends T> it) {
        return it instanceof et ? (et) it : new et(it);
    }

    static <T> ListIterator<T> i(Iterator<T> it) {
        return (ListIterator) it;
    }
}
