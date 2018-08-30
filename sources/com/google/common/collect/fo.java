package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$com.google.common.collect.gi;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class fo<E> implements Iterator<E> {
    int b;
    int c = -1;
    fs<K, V> d;
    AtomicReferenceArray<ReferenceEntry<K, V>> e;
    ReferenceEntry<K, V> f;
    gi g;
    gi h;
    final /* synthetic */ MapMakerInternalMap i;

    fo(MapMakerInternalMap mapMakerInternalMap) {
        this.i = mapMakerInternalMap;
        this.b = mapMakerInternalMap.c.length - 1;
        b();
    }

    boolean a(ReferenceEntry<K, V> referenceEntry) {
        try {
            Object key = referenceEntry.getKey();
            Object b = this.i.b((ReferenceEntry) referenceEntry);
            if (b != null) {
                this.g = new gi(this.i, key, b);
                return true;
            }
            this.d.n();
            return false;
        } finally {
            this.d.n();
        }
    }

    final void b() {
        this.g = null;
        if (!c() && !d()) {
            while (this.b >= 0) {
                fs[] fsVarArr = this.i.c;
                int i = this.b;
                this.b = i - 1;
                this.d = fsVarArr[i];
                if (this.d.b != 0) {
                    this.e = this.d.e;
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

    gi e() {
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
        ba.a(this.h != null);
        this.i.remove(this.h.getKey());
        this.h = null;
    }
}
