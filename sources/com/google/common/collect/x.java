package com.google.common.collect;

import com.google.common.collect.j$com.google.common.collect.u.com.google.common.collect.v;
import java.util.ListIterator;

class x extends v implements ListIterator<V> {
    final /* synthetic */ w d;

    x(w wVar) {
        this.d = wVar;
        super(wVar);
    }

    public x(w wVar, int i) {
        this.d = wVar;
        super(wVar, wVar.g().listIterator(i));
    }

    private ListIterator<V> c() {
        return (ListIterator) b();
    }

    public void add(V v) {
        boolean isEmpty = this.d.isEmpty();
        c().add(v);
        this.d.g.b = this.d.g.b + 1;
        if (isEmpty) {
            this.d.d();
        }
    }

    public boolean hasPrevious() {
        return c().hasPrevious();
    }

    public int nextIndex() {
        return c().nextIndex();
    }

    public V previous() {
        return c().previous();
    }

    public int previousIndex() {
        return c().previousIndex();
    }

    public void set(V v) {
        c().set(v);
    }
}
