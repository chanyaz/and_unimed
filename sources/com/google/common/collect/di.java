package com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;

public class di<K, V> {
    dl<K, V>[] a;
    int b;

    public di() {
        this(4);
    }

    di(int i) {
        this.a = new dl[i];
        this.b = 0;
    }

    private void a(int i) {
        if (i > this.a.length) {
            this.a = (dl[]) hc.b(this.a, cy.a(this.a.length, i));
        }
    }

    public di<K, V> a(Entry<? extends K, ? extends V> entry) {
        return b(entry.getKey(), entry.getValue());
    }

    public ImmutableMap<K, V> b() {
        switch (this.b) {
            case 0:
                return ImmutableMap.i();
            case 1:
                return ImmutableMap.b(this.a[0].getKey(), this.a[0].getValue());
            default:
                return new hm(this.b, this.a);
        }
    }

    public di<K, V> b(K k, V v) {
        a(this.b + 1);
        dl c = ImmutableMap.c(k, v);
        dl[] dlVarArr = this.a;
        int i = this.b;
        this.b = i + 1;
        dlVarArr[i] = c;
        return this;
    }

    public di<K, V> b(Map<? extends K, ? extends V> map) {
        a(this.b + map.size());
        for (Entry a : map.entrySet()) {
            a(a);
        }
        return this;
    }
}
