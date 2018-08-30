package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class dq<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> a;

    dq(ImmutableMap<K, V> immutableMap) {
        this.a = immutableMap;
    }

    boolean c() {
        return true;
    }

    public boolean contains(@Nullable Object obj) {
        return obj != null && er.a(iterator(), obj);
    }

    ImmutableList<V> f() {
        final ImmutableList b = this.a.entrySet().b();
        return new ct<V>() {
            ImmutableCollection<V> d() {
                return dq.this;
            }

            public V get(int i) {
                return ((Entry) b.get(i)).getValue();
            }
        };
    }

    /* renamed from: h_ */
    public jl<V> iterator() {
        return Maps.a(this.a.entrySet().iterator());
    }

    public int size() {
        return this.a.size();
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new dr(this.a);
    }
}
