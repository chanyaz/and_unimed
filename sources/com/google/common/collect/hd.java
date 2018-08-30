package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.s;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class hd<T> implements Comparator<T> {
    protected hd() {
    }

    @GwtCompatible(serializable = true)
    public static <T> hd<T> a(Comparator<T> comparator) {
        return comparator instanceof hd ? (hd) comparator : new bc(comparator);
    }

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> hd<C> b() {
        return hb.a;
    }

    public <E extends T> ImmutableList<E> a(Iterable<E> iterable) {
        Object[] c = eq.c(iterable);
        for (Object a : c) {
            s.a(a);
        }
        Arrays.sort(c, this);
        return ImmutableList.b(c);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> hd<S> a() {
        return new hw(this);
    }

    @GwtCompatible(serializable = true)
    public <F> hd<F> a(Function<F, ? extends T> function) {
        return new az(function, this);
    }

    <T2 extends T> hd<Entry<T2, ?>> c() {
        return a(Maps.a());
    }

    public abstract int compare(@Nullable T t, @Nullable T t2);
}
