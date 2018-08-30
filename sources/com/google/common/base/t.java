package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class t {
    private static final m a = m.a(",");

    private t() {
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> a() {
        return y.ALWAYS_TRUE.a();
    }

    public static <T> Predicate<T> a(Predicate<T> predicate) {
        return new x(predicate);
    }

    public static <A, B> Predicate<A> a(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new u(predicate, function, null);
    }

    public static <T> Predicate<T> a(@Nullable T t) {
        return t == null ? b() : new w(t, null);
    }

    public static <T> Predicate<T> a(Collection<? extends T> collection) {
        return new v(collection, null);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> b() {
        return y.IS_NULL.a();
    }
}
