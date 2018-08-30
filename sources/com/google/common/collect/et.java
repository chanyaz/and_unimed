package com.google.common.collect;

import com.google.common.base.s;
import java.util.Iterator;

class et<E> implements PeekingIterator<E> {
    private final Iterator<? extends E> a;
    private boolean b;
    private E c;

    public et(Iterator<? extends E> it) {
        this.a = (Iterator) s.a((Object) it);
    }

    public boolean hasNext() {
        return this.b || this.a.hasNext();
    }

    public E next() {
        if (!this.b) {
            return this.a.next();
        }
        E e = this.c;
        this.b = false;
        this.c = null;
        return e;
    }

    public E peek() {
        if (!this.b) {
            this.c = this.a.next();
            this.b = true;
        }
        return this.c;
    }

    public void remove() {
        s.b(!this.b, (Object) "Can't remove after you've peeked at next");
        this.a.remove();
    }
}
