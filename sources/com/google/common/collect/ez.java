package com.google.common.collect;

import com.google.common.base.s;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Map.Entry;

class ez implements ListIterator<Entry<K, V>> {
    int a;
    ey<K, V> b;
    ey<K, V> c;
    ey<K, V> d;
    int e = this.f.e;
    final /* synthetic */ LinkedListMultimap f;

    ez(LinkedListMultimap linkedListMultimap, int i) {
        this.f = linkedListMultimap;
        int size = linkedListMultimap.size();
        s.b(i, size);
        int i2;
        if (i < size / 2) {
            this.b = linkedListMultimap.a;
            while (true) {
                i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                next();
                i = i2;
            }
        } else {
            this.d = linkedListMultimap.b;
            this.a = size;
            while (true) {
                i2 = i + 1;
                if (i >= size) {
                    break;
                }
                previous();
                i = i2;
            }
        }
        this.c = null;
    }

    private void c() {
        if (this.f.e != this.e) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public ey<K, V> next() {
        c();
        LinkedListMultimap.c(this.b);
        ey eyVar = this.b;
        this.c = eyVar;
        this.d = eyVar;
        this.b = this.b.c;
        this.a++;
        return this.c;
    }

    void a(V v) {
        s.b(this.c != null);
        this.c.b = v;
    }

    /* renamed from: a */
    public void set(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public ey<K, V> previous() {
        c();
        LinkedListMultimap.c(this.d);
        ey eyVar = this.d;
        this.c = eyVar;
        this.b = eyVar;
        this.d = this.d.d;
        this.a--;
        return this.c;
    }

    /* renamed from: b */
    public void add(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        c();
        return this.b != null;
    }

    public boolean hasPrevious() {
        c();
        return this.d != null;
    }

    public int nextIndex() {
        return this.a;
    }

    public int previousIndex() {
        return this.a - 1;
    }

    public void remove() {
        c();
        ba.a(this.c != null);
        if (this.c != this.b) {
            this.d = this.c.d;
            this.a--;
        } else {
            this.b = this.c.c;
        }
        this.f.a(this.c);
        this.c = null;
        this.e = this.f.e;
    }
}
