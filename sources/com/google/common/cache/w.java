package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.aa;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.x;
import com.google.common.util.concurrent.z;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class w<K, V> implements ValueReference<K, V> {
    volatile ValueReference<K, V> a;
    final x<V> b;
    final aa c;

    public w() {
        this(LocalCache.i());
    }

    public w(ValueReference<K, V> valueReference) {
        this.b = x.c();
        this.c = aa.a();
        this.a = valueReference;
    }

    private ListenableFuture<V> b(Throwable th) {
        return Futures.a(th);
    }

    public long a() {
        return this.c.a(TimeUnit.NANOSECONDS);
    }

    public ListenableFuture<V> a(K k, CacheLoader<? super K, V> cacheLoader) {
        this.c.b();
        Object obj = this.a.get();
        if (obj == null) {
            try {
                obj = cacheLoader.a(k);
                return a(obj) ? this.b : Futures.a(obj);
            } catch (Throwable th) {
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return a(th) ? this.b : b(th);
            }
        } else {
            ListenableFuture a = cacheLoader.a(k, obj);
            return a == null ? Futures.a(null) : Futures.a(a, new Function<V, V>() {
                public V apply(V v) {
                    w.this.a((Object) v);
                    return v;
                }
            });
        }
    }

    public boolean a(@Nullable V v) {
        return this.b.a((Object) v);
    }

    public boolean a(Throwable th) {
        return this.b.a(th);
    }

    public ValueReference<K, V> b() {
        return this.a;
    }

    public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @Nullable V v, ReferenceEntry<K, V> referenceEntry) {
        return this;
    }

    public V get() {
        return this.a.get();
    }

    public ReferenceEntry<K, V> getEntry() {
        return null;
    }

    public int getWeight() {
        return this.a.getWeight();
    }

    public boolean isActive() {
        return this.a.isActive();
    }

    public boolean isLoading() {
        return true;
    }

    public void notifyNewValue(@Nullable V v) {
        if (v != null) {
            a((Object) v);
        } else {
            this.a = LocalCache.i();
        }
    }

    public V waitForValue() {
        return z.a(this.b);
    }
}
