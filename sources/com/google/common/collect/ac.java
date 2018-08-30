package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;

class ac implements Iterator<E> {
    final Iterator<Entry<E, bh>> a;
    Entry<E, bh> b;
    int c;
    boolean d;
    final /* synthetic */ ab e;

    ac(ab abVar) {
        this.e = abVar;
        this.a = abVar.a.entrySet().iterator();
    }

    public boolean hasNext() {
        return this.c > 0 || this.a.hasNext();
    }

    public E next() {
        if (this.c == 0) {
            this.b = (Entry) this.a.next();
            this.c = ((bh) this.b.getValue()).a();
        }
        this.c--;
        this.d = true;
        return this.b.getKey();
    }

    public void remove() {
        ba.a(this.d);
        if (((bh) this.b.getValue()).a() <= 0) {
            throw new ConcurrentModificationException();
        }
        if (((bh) this.b.getValue()).b(-1) == 0) {
            this.a.remove();
        }
        this.e.b = this.e.b - 1;
        this.d = false;
    }
}
