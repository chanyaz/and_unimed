package com.google.common.collect;

import java.util.Map.Entry;

class hs extends dm<K, V> {
    final /* synthetic */ hr a;

    private hs(hr hrVar) {
        this.a = hrVar;
    }

    ImmutableMap<K, V> e() {
        return this.a;
    }

    ImmutableList<Entry<K, V>> f() {
        return new ct<Entry<K, V>>() {
            private final ImmutableList<K> b = hs.this.a.keySet().b();

            /* renamed from: b */
            public Entry<K, V> get(int i) {
                return Maps.a(this.b.get(i), hs.this.a.b.get(i));
            }

            ImmutableCollection<Entry<K, V>> d() {
                return hs.this;
            }
        };
    }

    /* renamed from: h_ */
    public jl<Entry<K, V>> iterator() {
        return b().iterator();
    }
}
