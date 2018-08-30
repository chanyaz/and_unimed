package com.google.common.collect;

import com.google.common.base.s;
import java.util.Iterator;

public class dx<E> extends cy<E> {
    final Multiset<E> a;

    public dx() {
        this(LinkedHashMultiset.e());
    }

    dx(Multiset<E> multiset) {
        this.a = multiset;
    }

    /* renamed from: a */
    public dx<E> b(E e) {
        this.a.add(s.a((Object) e));
        return this;
    }

    public dx<E> a(E e, int i) {
        this.a.add(s.a((Object) e), i);
        return this;
    }

    /* renamed from: b */
    public dx<E> a(Iterator<? extends E> it) {
        super.a((Iterator) it);
        return this;
    }

    /* renamed from: b */
    public dx<E> a(E... eArr) {
        super.a((Object[]) eArr);
        return this;
    }
}
