package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

final class gz<E> extends gw<E> implements Serializable {
    private static final long serialVersionUID = 0;
    @Nullable
    final E a;
    final int b;

    gz(@Nullable E e, int i) {
        this.a = e;
        this.b = i;
        ba.a(i, "count");
    }

    public int getCount() {
        return this.b;
    }

    @Nullable
    public E getElement() {
        return this.a;
    }
}
