package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import com.google.common.collect.Multiset.Entry;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class ai<E> extends AbstractCollection<E> implements Multiset<E> {
    private transient Set<E> a;
    private transient Set<Entry<E>> b;

    ai() {
    }

    abstract Iterator<Entry<E>> a();

    public int add(@Nullable E e, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean add(@Nullable E e) {
        add(e, 1);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return gv.a((Multiset) this, (Collection) collection);
    }

    abstract int b();

    Set<E> c() {
        return new aj(this);
    }

    public void clear() {
        er.g(a());
    }

    public boolean contains(@Nullable Object obj) {
        return count(obj) > 0;
    }

    public int count(@Nullable Object obj) {
        for (Entry entry : entrySet()) {
            if (o.a(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    Set<Entry<E>> d() {
        return new ak(this);
    }

    public Set<E> elementSet() {
        Set<E> set = this.a;
        if (set != null) {
            return set;
        }
        set = c();
        this.a = set;
        return set;
    }

    public Set<Entry<E>> entrySet() {
        Set<Entry<E>> set = this.b;
        if (set != null) {
            return set;
        }
        set = d();
        this.b = set;
        return set;
    }

    public boolean equals(@Nullable Object obj) {
        return gv.a((Multiset) this, obj);
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public Iterator<E> iterator() {
        return gv.a((Multiset) this);
    }

    public int remove(@Nullable Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(@Nullable Object obj) {
        return remove(obj, 1) > 0;
    }

    public boolean removeAll(Collection<?> collection) {
        return gv.b(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return gv.c(this, collection);
    }

    public int setCount(@Nullable E e, int i) {
        return gv.a(this, e, i);
    }

    public boolean setCount(@Nullable E e, int i, int i2) {
        return gv.a(this, e, i, i2);
    }

    public int size() {
        return gv.b((Multiset) this);
    }

    public String toString() {
        return entrySet().toString();
    }
}
