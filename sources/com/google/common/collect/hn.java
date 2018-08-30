package com.google.common.collect;

import java.util.Map.Entry;

class hn extends dm<K, V> {
    final /* synthetic */ hm a;

    private hn(hm hmVar) {
        this.a = hmVar;
    }

    ImmutableMap<K, V> e() {
        return this.a;
    }

    ImmutableList<Entry<K, V>> f() {
        return new hf((ImmutableCollection) this, this.a.a);
    }

    /* renamed from: h_ */
    public jl<Entry<K, V>> iterator() {
        return b().iterator();
    }
}
