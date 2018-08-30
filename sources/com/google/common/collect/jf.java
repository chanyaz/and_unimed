package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Iterator;

@GwtCompatible
abstract class jf<F, T> implements Iterator<T> {
    final Iterator<? extends F> c;

    jf(Iterator<? extends F> it) {
        this.c = (Iterator) s.a((Object) it);
    }

    abstract T a(F f);

    public final boolean hasNext() {
        return this.c.hasNext();
    }

    public final T next() {
        return a(this.c.next());
    }

    public final void remove() {
        this.c.remove();
    }
}
