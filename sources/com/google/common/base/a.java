package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class a<T> implements Iterator<T> {
    private b a = b.NOT_READY;
    private T b;

    protected a() {
    }

    private boolean c() {
        this.a = b.FAILED;
        this.b = a();
        if (this.a == b.DONE) {
            return false;
        }
        this.a = b.READY;
        return true;
    }

    protected abstract T a();

    protected final T b() {
        this.a = b.DONE;
        return null;
    }

    public final boolean hasNext() {
        s.b(this.a != b.FAILED);
        switch (this.a) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return c();
        }
    }

    public final T next() {
        if (hasNext()) {
            this.a = b.NOT_READY;
            T t = this.b;
            this.b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
