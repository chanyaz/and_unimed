package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
abstract class jg<F, T> extends jf<F, T> implements ListIterator<T> {
    jg(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> a() {
        return er.i(this.c);
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return a().hasPrevious();
    }

    public final int nextIndex() {
        return a().nextIndex();
    }

    public final T previous() {
        return a(a().previous());
    }

    public final int previousIndex() {
        return a().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }
}
