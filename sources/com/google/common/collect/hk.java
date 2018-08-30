package com.google.common.collect;

import javax.annotation.Nullable;

final class hk<K, V> extends dk<K, V> {
    @Nullable
    private final dk<K, V> a;
    @Nullable
    private final dk<K, V> b;

    hk(dk<K, V> dkVar, @Nullable dk<K, V> dkVar2, @Nullable dk<K, V> dkVar3) {
        super(dkVar);
        this.a = dkVar2;
        this.b = dkVar3;
    }

    @Nullable
    dk<K, V> a() {
        return this.a;
    }

    @Nullable
    dk<K, V> b() {
        return this.b;
    }
}
