package com.google.common.cache;

import com.google.common.base.s;
import com.google.common.cache.LocalCache$com.google.common.cache.aq;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class t<T> implements Iterator<T> {
    int b;
    int c = -1;
    y<K, V> d;
    AtomicReferenceArray<ReferenceEntry<K, V>> e;
    ReferenceEntry<K, V> f;
    aq g;
    aq h;
    final /* synthetic */ LocalCache i;

    t(LocalCache localCache) {
        this.i = localCache;
        this.b = localCache.e.length - 1;
        b();
    }

    boolean a(ReferenceEntry<K, V> referenceEntry) {
        try {
            long a = this.i.q.a();
            Object key = referenceEntry.getKey();
            Object a2 = this.i.a((ReferenceEntry) referenceEntry, a);
            if (a2 != null) {
                this.g = new aq(this.i, key, a2);
                return true;
            }
            this.d.m();
            return false;
        } finally {
            this.d.m();
        }
    }

    final void b() {
        this.g = null;
        if (!c() && !d()) {
            while (this.b >= 0) {
                y[] yVarArr = this.i.e;
                int i = this.b;
                this.b = i - 1;
                this.d = yVarArr[i];
                if (this.d.b != 0) {
                    this.e = this.d.f;
                    this.c = this.e.length() - 1;
                    if (d()) {
                        return;
                    }
                }
            }
        }
    }

    boolean c() {
        if (this.f != null) {
            this.f = this.f.getNext();
            while (this.f != null) {
                if (a(this.f)) {
                    return true;
                }
                this.f = this.f.getNext();
            }
        }
        return false;
    }

    boolean d() {
        while (this.c >= 0) {
            AtomicReferenceArray atomicReferenceArray = this.e;
            int i = this.c;
            this.c = i - 1;
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
            this.f = referenceEntry;
            if (referenceEntry != null && (a(this.f) || c())) {
                return true;
            }
        }
        return false;
    }

    aq e() {
        if (this.g == null) {
            throw new NoSuchElementException();
        }
        this.h = this.g;
        b();
        return this.h;
    }

    public boolean hasNext() {
        return this.g != null;
    }

    public void remove() {
        s.b(this.h != null);
        this.i.remove(this.h.getKey());
        this.h = null;
    }
}
