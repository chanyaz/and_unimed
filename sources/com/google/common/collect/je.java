package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

final class je<R, C, V> extends jd<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final R a;
    private final C b;
    private final V c;

    je(@Nullable R r, @Nullable C c, @Nullable V v) {
        this.a = r;
        this.b = c;
        this.c = v;
    }

    public C getColumnKey() {
        return this.b;
    }

    public R getRowKey() {
        return this.a;
    }

    public V getValue() {
        return this.c;
    }
}
