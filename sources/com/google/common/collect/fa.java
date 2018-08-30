package com.google.common.collect;

import com.google.common.base.s;
import java.util.ListIterator;
import javax.annotation.Nullable;

class fa implements ListIterator<V> {
    final Object a;
    int b;
    ey<K, V> c;
    ey<K, V> d;
    ey<K, V> e;
    final /* synthetic */ LinkedListMultimap f;

    fa(LinkedListMultimap linkedListMultimap, @Nullable Object obj) {
        this.f = linkedListMultimap;
        this.a = obj;
        ex exVar = (ex) linkedListMultimap.c.get(obj);
        this.c = exVar == null ? null : exVar.a;
    }

    public fa(LinkedListMultimap linkedListMultimap, @Nullable Object obj, int i) {
        this.f = linkedListMultimap;
        ex exVar = (ex) linkedListMultimap.c.get(obj);
        int i2 = exVar == null ? 0 : exVar.c;
        s.b(i, i2);
        int i3;
        if (i < i2 / 2) {
            this.c = exVar == null ? null : exVar.a;
            while (true) {
                i3 = i - 1;
                if (i <= 0) {
                    break;
                }
                next();
                i = i3;
            }
        } else {
            this.e = exVar == null ? null : exVar.b;
            this.b = i2;
            while (true) {
                i3 = i + 1;
                if (i >= i2) {
                    break;
                }
                previous();
                i = i3;
            }
        }
        this.a = obj;
        this.d = null;
    }

    public void add(V v) {
        this.e = this.f.a(this.a, v, this.c);
        this.b++;
        this.d = null;
    }

    public boolean hasNext() {
        return this.c != null;
    }

    public boolean hasPrevious() {
        return this.e != null;
    }

    public V next() {
        LinkedListMultimap.c(this.c);
        ey eyVar = this.c;
        this.d = eyVar;
        this.e = eyVar;
        this.c = this.c.e;
        this.b++;
        return this.d.b;
    }

    public int nextIndex() {
        return this.b;
    }

    public V previous() {
        LinkedListMultimap.c(this.e);
        ey eyVar = this.e;
        this.d = eyVar;
        this.c = eyVar;
        this.e = this.e.f;
        this.b--;
        return this.d.b;
    }

    public int previousIndex() {
        return this.b - 1;
    }

    public void remove() {
        ba.a(this.d != null);
        if (this.d != this.c) {
            this.e = this.d.f;
            this.b--;
        } else {
            this.c = this.d.e;
        }
        this.f.a(this.d);
        this.d = null;
    }

    public void set(V v) {
        s.b(this.d != null);
        this.d.b = v;
    }
}
