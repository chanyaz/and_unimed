package com.google.common.collect;

import javax.annotation.Nullable;

final class ho<K, V> extends dk<K, V> {
    private final dk<K, V> a;

    ho(dk<K, V> dkVar, dk<K, V> dkVar2) {
        super(dkVar);
        this.a = dkVar2;
    }

    ho(K k, V v, dk<K, V> dkVar) {
        super(k, v);
        this.a = dkVar;
    }

    dk<K, V> a() {
        return this.a;
    }

    @Nullable
    dk<K, V> b() {
        return null;
    }
}
