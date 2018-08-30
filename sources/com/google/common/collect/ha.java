package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class ha<E> implements Iterator<E> {
    private final Multiset<E> a;
    private final Iterator<Entry<E>> b;
    private Entry<E> c;
    private int d;
    private int e;
    private boolean f;

    ha(Multiset<E> multiset, Iterator<Entry<E>> it) {
        this.a = multiset;
        this.b = it;
    }

    public boolean hasNext() {
        return this.d > 0 || this.b.hasNext();
    }

    public E next() {
        if (hasNext()) {
            if (this.d == 0) {
                this.c = (Entry) this.b.next();
                int count = this.c.getCount();
                this.d = count;
                this.e = count;
            }
            this.d--;
            this.f = true;
            return this.c.getElement();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        ba.a(this.f);
        if (this.e == 1) {
            this.b.remove();
        } else {
            this.a.remove(this.c.getElement());
        }
        this.e--;
        this.f = false;
    }
}
