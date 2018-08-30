package com.google.common.collect;

import java.io.Serializable;

class dg implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;

    dg(Object[] objArr) {
        this.a = objArr;
    }

    Object readResolve() {
        return ImmutableList.a(this.a);
    }
}
