package com.google.common.collect;

import java.util.Map.Entry;

class ds<K, V> extends ImmutableCollection<Entry<K, V>> {
    private static final long serialVersionUID = 0;
    final ImmutableMultimap<K, V> a;

    ds(ImmutableMultimap<K, V> immutableMultimap) {
        this.a = immutableMultimap;
    }

    boolean c() {
        return this.a.a();
    }

    public boolean contains(Object obj) {
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
