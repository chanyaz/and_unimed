package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class do<K, V> extends ImmutableSet<K> {
    private final ImmutableMap<K, V> a;

    do(ImmutableMap<K, V> immutableMap) {
        this.a = immutableMap;
    }

    boolean c() {
        return true;
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    ImmutableList<K> f() {
        final ImmutableList b = this.a.entrySet().b();
        return new ct<K>() {
            ImmutableCollection<K> d() {
                return do.this;
            }

            public K get(int i) {
                return ((Entry) b.get(i)).getKey();
            }
        };
    }

    /* renamed from: h_ */
    public jl<K> iterator() {
        return b().iterator();
    }

    public int size() {
        return this.a.size();
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new dp(this.a);
    }
}
