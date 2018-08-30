package com.google.common.collect;

import java.util.Iterator;

public class ed<E> extends cx<E> {
    public ed() {
        this(4);
    }

    ed(int i) {
        super(i);
    }

    public ImmutableSet<E> a() {
        ImmutableSet<E> a = ImmutableSet.b(this.b, this.a);
        this.b = a.size();
        return a;
    }

    /* renamed from: b */
    public ed<E> a(Iterator<? extends E> it) {
        super.a((Iterator) it);
        return this;
    }

    /* renamed from: b */
    public ed<E> a(E... eArr) {
        super.a((Object[]) eArr);
        return this;
    }

    /* renamed from: c */
    public ed<E> b(E e) {
        super.b((Object) e);
        return this;
    }
}
