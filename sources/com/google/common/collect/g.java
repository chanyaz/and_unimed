package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class g<T> extends jl<T> {
    private h a = h.NOT_READY;
    private T b;

    protected g() {
    }

    private boolean c() {
        this.a = h.FAILED;
        this.b = a();
        if (this.a == h.DONE) {
            return false;
        }
        this.a = h.READY;
        return true;
    }

    protected abstract T a();

    protected final T b() {
        this.a = h.DONE;
        return null;
    }

    public final boolean hasNext() {
        s.b(this.a != h.FAILED);
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
            this.a = h.NOT_READY;
            T t = this.b;
            this.b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
