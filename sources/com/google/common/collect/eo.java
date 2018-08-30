package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

class eo<E> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super E> a;
    final Object[] b;

    public eo(Comparator<? super E> comparator, Object[] objArr) {
        this.a = comparator;
        this.b = objArr;
    }

    Object readResolve() {
        return new en(this.a).b(this.b).a();
    }
}
