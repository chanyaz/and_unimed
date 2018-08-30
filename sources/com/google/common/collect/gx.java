package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Iterator;

abstract class gx<E> extends ia<E> {
    gx() {
    }

    abstract Multiset<E> a();

    public void clear() {
        a().clear();
    }

    public boolean contains(Object obj) {
        return a().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return a().containsAll(collection);
    }

    public boolean isEmpty() {
        return a().isEmpty();
    }

    public Iterator<E> iterator() {
        return new jf<Entry<E>, E>(a().entrySet().iterator()) {
            E a(Entry<E> entry) {
                return entry.getElement();
            }
        };
    }

    public boolean remove(Object obj) {
        int count = a().count(obj);
        if (count <= 0) {
            return false;
        }
        a().remove(obj, count);
        return true;
    }

    public int size() {
        return a().entrySet().size();
    }
}
