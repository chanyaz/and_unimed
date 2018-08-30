package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

class ew implements Iterator<K> {
    final Set<K> a;
    ey<K, V> b;
    ey<K, V> c;
    int d;
    final /* synthetic */ LinkedListMultimap e;

    private ew(LinkedListMultimap linkedListMultimap) {
        this.e = linkedListMultimap;
        this.a = hz.a(this.e.keySet().size());
        this.b = this.e.a;
        this.d = this.e.e;
    }

    private void a() {
        if (this.e.e != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean hasNext() {
        a();
        return this.b != null;
    }

    public K next() {
        a();
        LinkedListMultimap.c(this.b);
        this.c = this.b;
        this.a.add(this.c.a);
        do {
            this.b = this.b.c;
            if (this.b == null) {
                break;
            }
        } while (!this.a.add(this.b.a));
        return this.c.a;
    }

    public void remove() {
        a();
        ba.a(this.c != null);
        this.e.b(this.c.a);
        this.c = null;
        this.d = this.e.e;
    }
}
