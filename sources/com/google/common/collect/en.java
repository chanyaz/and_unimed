package com.google.common.collect;

import com.google.common.base.s;
import java.util.Comparator;
import java.util.Iterator;

public final class en<E> extends ed<E> {
    private final Comparator<? super E> c;

    public en(Comparator<? super E> comparator) {
        this.c = (Comparator) s.a((Object) comparator);
    }

    /* renamed from: b */
    public ImmutableSortedSet<E> a() {
        ImmutableSortedSet<E> a = ImmutableSortedSet.a(this.c, this.b, this.a);
        this.b = a.size();
        return a;
    }

    /* renamed from: c */
    public en<E> b(Iterator<? extends E> it) {
        super.a((Iterator) it);
        return this;
    }

    /* renamed from: c */
    public en<E> b(E... eArr) {
        super.a((Object[]) eArr);
        return this;
    }

    /* renamed from: d */
    public en<E> c(E e) {
        super.b(e);
        return this;
    }
}
