package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class by<T> extends cc implements Iterator<T> {
    protected by() {
    }

    /* renamed from: a */
    protected abstract Iterator<T> b();

    public boolean hasNext() {
        return b().hasNext();
    }

    public T next() {
        return b().next();
    }

    public void remove() {
        b().remove();
    }
}
