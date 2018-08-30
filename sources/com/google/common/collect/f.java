package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class f<E> extends jm<E> {
    private final int a;
    private int b;

    protected f(int i) {
        this(i, 0);
    }

    protected f(int i, int i2) {
        s.b(i2, i);
        this.a = i;
        this.b = i2;
    }

    protected abstract E a(int i);

    public final boolean hasNext() {
        return this.b < this.a;
    }

    public final boolean hasPrevious() {
        return this.b > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.b;
            this.b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.b;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.b - 1;
            this.b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.b - 1;
    }
}
