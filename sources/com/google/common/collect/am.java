package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class am<T> extends jl<T> {
    private T a;

    protected am(@Nullable T t) {
        this.a = t;
    }

    protected abstract T a(T t);

    public final boolean hasNext() {
        return this.a != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.a;
                return t;
            } finally {
                this.a = a(this.a);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
