package com.google.common.collect;

import java.io.Serializable;

class ee implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;

    ee(Object[] objArr) {
        this.a = objArr;
    }

    Object readResolve() {
        return ImmutableSet.a(this.a);
    }
}
