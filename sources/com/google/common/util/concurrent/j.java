package com.google.common.util.concurrent;

import com.google.common.base.s;

public abstract class j<V> extends i<V> {
    private final ListenableFuture<V> a;

    protected j(ListenableFuture<V> listenableFuture) {
        this.a = (ListenableFuture) s.a((Object) listenableFuture);
    }

    /* renamed from: c */
    protected final ListenableFuture<V> b() {
        return this.a;
    }
}
