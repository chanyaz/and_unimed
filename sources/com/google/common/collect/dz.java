package com.google.common.collect;

import java.io.Serializable;

class dz<E> implements Serializable {
    final ImmutableMultiset<E> a;

    dz(ImmutableMultiset<E> immutableMultiset) {
        this.a = immutableMultiset;
    }

    Object readResolve() {
        return this.a.entrySet();
    }
}
