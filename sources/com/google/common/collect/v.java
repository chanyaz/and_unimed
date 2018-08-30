package com.google.common.collect;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class v implements Iterator<V> {
    final Iterator<V> a;
    final Collection<V> b = this.c.c;
    final /* synthetic */ u c;

    v(u uVar) {
        this.c = uVar;
        this.a = uVar.f.b(uVar.c);
    }

    v(u uVar, Iterator<V> it) {
        this.c = uVar;
        this.a = it;
    }

    void a() {
        this.c.a();
        if (this.c.c != this.b) {
            throw new ConcurrentModificationException();
        }
    }

    Iterator<V> b() {
        a();
        return this.a;
    }

    public boolean hasNext() {
        a();
        return this.a.hasNext();
    }

    public V next() {
        a();
        return this.a.next();
    }

    public void remove() {
        this.a.remove();
        this.c.f.b = this.c.f.b - 1;
        this.c.b();
    }
}
