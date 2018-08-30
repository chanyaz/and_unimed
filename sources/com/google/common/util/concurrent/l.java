package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;

class l<V> extends m<V> {
    private final Throwable a;

    l(Throwable th) {
        super();
        this.a = th;
    }

    public V get() {
        throw new ExecutionException(this.a);
    }
}
