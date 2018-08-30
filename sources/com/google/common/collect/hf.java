package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;

@GwtCompatible(emulated = true)
class hf<E> extends ct<E> {
    private final ImmutableCollection<E> a;
    private final ImmutableList<? extends E> b;

    hf(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.a = immutableCollection;
        this.b = immutableList;
    }

    hf(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this((ImmutableCollection) immutableCollection, ImmutableList.b(objArr));
    }

    @GwtIncompatible("not present in emulated superclass")
    int a(Object[] objArr, int i) {
        return this.b.a(objArr, i);
    }

    /* renamed from: a */
    public jm<E> listIterator(int i) {
        return this.b.listIterator(i);
    }

    ImmutableCollection<E> d() {
        return this.a;
    }

    public E get(int i) {
        return this.b.get(i);
    }
}
