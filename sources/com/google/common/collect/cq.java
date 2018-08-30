package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class cq<T> implements Iterator<T> {
    int b = 0;
    cj<K, V> c = null;
    cj<K, V> d = null;
    int e = this.f.e;
    final /* synthetic */ HashBiMap f;

    cq(HashBiMap hashBiMap) {
        this.f = hashBiMap;
    }

    private void a() {
        if (this.f.e != this.e) {
            throw new ConcurrentModificationException();
        }
    }

    abstract T b(cj<K, V> cjVar);

    public boolean hasNext() {
        a();
        if (this.c != null) {
            return true;
        }
        while (this.b < this.f.a.length) {
            if (this.f.a[this.b] != null) {
                cj[] b = this.f.a;
                int i = this.b;
                this.b = i + 1;
                this.c = b[i];
                return true;
            }
            this.b++;
        }
        return false;
    }

    public T next() {
        a();
        if (hasNext()) {
            cj cjVar = this.c;
            this.c = cjVar.c;
            this.d = cjVar;
            return b(cjVar);
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        a();
        ba.a(this.d != null);
        this.f.a(this.d);
        this.e = this.f.e;
        this.d = null;
    }
}
