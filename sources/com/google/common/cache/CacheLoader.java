package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

@GwtCompatible(emulated = true)
public abstract class CacheLoader<K, V> {

    public final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    protected CacheLoader() {
    }

    @GwtIncompatible("Futures")
    public ListenableFuture<V> a(K k, V v) {
        s.a((Object) k);
        s.a((Object) v);
        return Futures.a(a(k));
    }

    public abstract V a(K k);
}
