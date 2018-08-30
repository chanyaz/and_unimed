package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class jl<E> implements Iterator<E> {
    protected jl() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
