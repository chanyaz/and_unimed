package com.google.common.collect;

import com.google.common.base.s;
import java.util.Comparator;
import java.util.Iterator;

public class ek<E> extends dx<E> {
    private final Comparator<? super E> b;

    public ek(Comparator<? super E> comparator) {
        super(TreeMultiset.a((Comparator) comparator));
        this.b = (Comparator) s.a((Object) comparator);
    }

    public ImmutableSortedMultiset<E> a() {
        return ImmutableSortedMultiset.a((SortedMultiset) this.a);
    }

    /* renamed from: b */
    public ek<E> a(E e, int i) {
        super.a(e, i);
        return this;
    }

    /* renamed from: c */
    public ek<E> b(E e) {
        super.b((Object) e);
        return this;
    }

    /* renamed from: c */
    public ek<E> b(Iterator<? extends E> it) {
        super.a((Iterator) it);
        return this;
    }

    /* renamed from: c */
    public ek<E> b(E... eArr) {
        super.a((Object[]) eArr);
        return this;
    }
}
