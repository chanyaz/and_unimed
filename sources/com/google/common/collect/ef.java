package com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class ef<K, V> extends ImmutableSet<Entry<K, V>> {
    private final transient ImmutableSetMultimap<K, V> a;

    ef(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        this.a = immutableSetMultimap;
    }

    boolean c() {
        return false;
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.a.containsEntry(entry.getKey(), entry.getValue());
    }

    /* renamed from: h_ */
    public jl<Entry<K, V>> iterator() {
        return this.a.h();
    }

    public int size() {
        return this.a.size();
    }
}
