package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.o;
import javax.annotation.Nullable;

@VisibleForTesting
final class eu<K, V> extends cz<K, V> implements ValueSetLink<K, V> {
    final int a;
    @Nullable
    eu<K, V> b;
    ValueSetLink<K, V> c;
    ValueSetLink<K, V> d;
    eu<K, V> g;
    eu<K, V> h;

    eu(@Nullable K k, @Nullable V v, int i, @Nullable eu<K, V> euVar) {
        super(k, v);
        this.a = i;
        this.b = euVar;
    }

    public eu<K, V> a() {
        return this.g;
    }

    public void a(eu<K, V> euVar) {
        this.h = euVar;
    }

    boolean a(@Nullable Object obj, int i) {
        return this.a == i && o.a(getValue(), obj);
    }

    public eu<K, V> b() {
        return this.h;
    }

    public void b(eu<K, V> euVar) {
        this.g = euVar;
    }

    public ValueSetLink<K, V> getPredecessorInValueSet() {
        return this.c;
    }

    public ValueSetLink<K, V> getSuccessorInValueSet() {
        return this.d;
    }

    public void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink) {
        this.c = valueSetLink;
    }

    public void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink) {
        this.d = valueSetLink;
    }
}
