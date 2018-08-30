package com.google.common.collect;

import java.util.Iterator;

public final class de<E> extends cx<E> {
    public de() {
        this(4);
    }

    de(int i) {
        super(i);
    }

    public ImmutableList<E> a() {
        return ImmutableList.b(this.a, this.b);
    }

    /* renamed from: b */
    public de<E> a(Iterator<? extends E> it) {
        super.a((Iterator) it);
        return this;
    }

    /* renamed from: b */
    public de<E> a(E... eArr) {
        super.a((Object[]) eArr);
        return this;
    }

    /* renamed from: c */
    public de<E> b(E e) {
        super.b((Object) e);
        return this;
    }
}
