package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.s;
import com.google.common.collect.hd;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@Beta
public final class Futures {
    private static final AsyncFunction<ListenableFuture<Object>, Object> a = new AsyncFunction<ListenableFuture<Object>, Object>() {
        /* renamed from: a */
        public ListenableFuture<Object> apply(ListenableFuture<Object> listenableFuture) {
            return listenableFuture;
        }
    };
    private static final hd<Constructor<?>> b = hd.b().a(new Function<Constructor<?>, Boolean>() {
        /* renamed from: a */
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }).a();

    interface FutureCombiner<V, C> {
        C combine(List<Optional<V>> list);
    }

    private Futures() {
    }

    public static <I, O> ListenableFuture<O> a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        return a((ListenableFuture) listenableFuture, (Function) function, p.a());
    }

    public static <I, O> ListenableFuture<O> a(ListenableFuture<I> listenableFuture, final Function<? super I, ? extends O> function, Executor executor) {
        s.a((Object) function);
        return a((ListenableFuture) listenableFuture, new AsyncFunction<I, O>() {
            public ListenableFuture<O> apply(I i) {
                return Futures.a(function.apply(i));
            }
        }, executor);
    }

    public static <I, O> ListenableFuture<O> a(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Object kVar = new k(asyncFunction, listenableFuture, null);
        listenableFuture.addListener(kVar, executor);
        return kVar;
    }

    public static <V> ListenableFuture<V> a(@Nullable V v) {
        return new n(v);
    }

    public static <V> ListenableFuture<V> a(Throwable th) {
        s.a((Object) th);
        return new l(th);
    }
}
