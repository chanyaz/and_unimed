package com.google.common.util.concurrent;

import javax.annotation.Nullable;

public final class x<V> extends a<V> {
    private x() {
    }

    public static <V> x<V> c() {
        return new x();
    }

    public boolean a(@Nullable V v) {
        return super.a((Object) v);
    }

    public boolean a(Throwable th) {
        return super.a(th);
    }
}
