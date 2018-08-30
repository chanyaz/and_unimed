package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class fc<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;
    final List<F> a;
    final Function<? super F, ? extends T> b;

    fc(List<F> list, Function<? super F, ? extends T> function) {
        this.a = (List) s.a((Object) list);
        this.b = (Function) s.a((Object) function);
    }

    public void clear() {
        this.a.clear();
    }

    public T get(int i) {
        return this.b.apply(this.a.get(i));
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    public ListIterator<T> listIterator(int i) {
        return new jg<F, T>(this.a.listIterator(i)) {
            T a(F f) {
                return fc.this.b.apply(f);
            }
        };
    }

    public T remove(int i) {
        return this.b.apply(this.a.remove(i));
    }

    public int size() {
        return this.a.size();
    }
}
