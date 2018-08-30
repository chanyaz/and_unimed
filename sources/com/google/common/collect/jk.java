package com.google.common.collect;

import com.google.common.collect.TreeMultiset.AnonymousClass1;
import java.util.ConcurrentModificationException;
import javax.annotation.Nullable;

final class jk<T> {
    @Nullable
    private T a;

    private jk() {
    }

    /* synthetic */ jk(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Nullable
    public T a() {
        return this.a;
    }

    public void a(@Nullable T t, T t2) {
        if (this.a != t) {
            throw new ConcurrentModificationException();
        }
        this.a = t2;
    }
}
