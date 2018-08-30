package com.google.common.collect;

import java.util.Map.Entry;

final class hi extends dm<V, K> {
    final /* synthetic */ hh a;

    hi(hh hhVar) {
        this.a = hhVar;
    }

    ImmutableMap<V, K> e() {
        return this.a;
    }

    ImmutableList<Entry<V, K>> f() {
        return new ct<Entry<V, K>>() {
            /* renamed from: b */
            public Entry<V, K> get(int i) {
                Entry entry = hi.this.a.a.c[i];
                return Maps.a(entry.getValue(), entry.getKey());
            }

            ImmutableCollection<Entry<V, K>> d() {
                return hi.this;
            }
        };
    }

    boolean f_() {
        return true;
    }

    /* renamed from: h_ */
    public jl<Entry<V, K>> iterator() {
        return b().iterator();
    }

    public int hashCode() {
        return this.a.a.e;
    }
}
